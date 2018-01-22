package com.slazien;


import java.io.*;
import java.util.*;


public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    // 1. 0 - 3: contain the number of locations (size of int)
    // 2. 4 - 7: contain the start offset of the locations section
    // 3. 8 - 1699: contain the index (which is 1692 bytes long)
    // 4. 1700 - end: contain location records (actual data)
    // High-level overview:
    // a) Write number of locations
    // b) Write locations, storing offsets in index
    // c) Write index (jumping back to space before locations in the file - this is where random access comes into play)
    public static void main(String[] args) throws IOException {
        // Open the file for r+w as well as write synchronously - don't have to synchronise the threads yourself
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            // Write number of locations in bytes 0 - 4
            rao.writeInt(locations.size());

            // Calculate size of index: number of locations * 3 ints * size of int (bytes)
            int indexSize = locations.size() * 3 * Integer.BYTES;

            // Calculate current position of the file pointer
            // Account for the value we've already written (getFilePointer())
            // Account for the integer we're about to write to the file (Integer.BYTES)
            // Cast to int (default long), unless need to work with large files, then stick to long
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);
            long indexStart = rao.getFilePointer();

            // Write locations to get the offsets needed to write the index later on

            // Need startPointer to calculate record's length after we've written it to a file
            int startPointer = locationStart;

            // Move the file pointer to the first location's offset (only for the first location because after that we
            // write all the data sequentially)
            rao.seek(startPointer);

            for (Location location : locations.values()) {
                // Write location ID
                rao.writeInt(location.getLocationID());

                // Write location description
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();

                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        // direction, locationID, direction, locationID
                        // e.g. N,1,U,2
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        // don't have to write "," for the last location, but no issue in our case
                        builder.append(",");
                    }
                }

                rao.writeUTF(builder.toString());

                // Start byte for this location is startPointer, record length is current position of the
                // file pointer - startPointer
                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));

                // Add to index
                index.put(location.getLocationID(), record);

                // Update startPointer location to write next location in the correct position
                startPointer = (int) rao.getFilePointer();
            }

            // Write index block
            rao.seek(indexStart);
            for (Integer locationID : index.keySet()) {
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
        }
    }

    static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");

            // Read number of locations (bytes 0-3)
            int numLocations = ra.readInt();

            // Get offset of locations block
            long locationStartPoint = ra.readInt();

            // Read index data
            while (ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }


        } catch (IOException e) {
            System.out.println("IOException in static initializer: " + e.getMessage());
        }

//        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() + " exits");
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    eof = true;
//                    System.out.println("---REACHED EOF---");
//                }
//            }
//        } catch (InvalidClassException e) {
//            System.out.println("InvalidClassException: " + e.getMessage());
//        } catch (IOException io) {
//            System.out.println("IO Exception: " + io.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.out.println("ClassNotFoundException: " + e.getMessage());
//        }
    }

    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);

        if (locationId != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                System.out.println("exitpart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

    public void close() throws IOException {
        ra.close();
    }
}
