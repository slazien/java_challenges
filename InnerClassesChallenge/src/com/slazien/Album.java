package com.slazien;

import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    private class SongList {
        private ArrayList<Song> songList;

        public SongList() {
            this.songList = new ArrayList<Song>();
        }

        public boolean addSong(Song song) {
            if (songList.contains(song)) {
                return false;
            }

            this.songList.add(song);
            return true;
        }

        public Song findSong(String title) {
            for (Song checkedSong : this.songList) {
                if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index > 0) && (index < songList.size())) {
                return songList.get(index);
            }

            return null;
        }
    }

    public boolean addSong(String title, double duration) {
        return this.songs.addSong(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);

        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


}
