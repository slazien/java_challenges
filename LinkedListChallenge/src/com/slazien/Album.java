package com.slazien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new ArrayList<Song>();
    }

    public boolean addSong(String songName, double duration) {
        Song song = findSong(songName);
        if (song == null) {
            this.songList.add(new Song(songName, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String songName) {
//        for(int i=0; i<this.songList.size(), i++) {
        for (Song currentSong : this.songList) {
//            Song currentSong = this.songList.get(i);
            if (currentSong.getTitle().equals(songName)) {
                return currentSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if((index >= 0) && (index < this.songList.size())) {
            playList.add(this.songList.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null) {
            playList.add(song);
            return true;
        }
        System.out.println("Song " + title + " is not in this album");
        return false;
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newSong) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newSong);
            if (comparison == 0) {
                // do not add
                System.out.println(newSong + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // should appear before current
                stringListIterator.previous();
                stringListIterator.add(newSong);
                return true;
            } else if (comparison < 0) {
                // move on to the next city
            }
        }

        stringListIterator.add(newSong);
        return true;
    }
}
