package com.slazien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Colors", "From Kid");
        album.addSong("Colors", 3.2);
        album.addSong("Dark Moon", 2.7);
        album.addSong("New Beginning", 3.8);
        album.addSong("Old End", 1.8);
        albums.add(album);

        album = new Album("Vagabond", "Stu Larsen");
        album.addSong("San Francisco", 2.5);
        album.addSong("Thirteen Sad Farewells", 3.4);
        album.addSong("Maybe I am", 5.7);
        album.addSong("Far Away From Here", 1.9);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("Dark Moon", playList);
        albums.get(0).addToPlaylist("New Beginning", playList);
        albums.get(0).addToPlaylist("Blacks & Whites", playList);
        albums.get(1).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist(10, playList);

        play(playList);
//        printMenu();
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("Empty playlist");
            return;
        } else {
            Song currentSong = listIterator.next();
            System.out.println("Now playing: " + currentSong.getTitle() + ": " + currentSong.getDuration());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            switch (action) {
                case 0: {
                    System.out.println("Quitting...");
                    quit = true;
                    break;
                }

                case 1: {
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        forward = false;
                    }
                    break;
                }

                case 2: {
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("At playlist beginning");
                        forward = true;
                    }
                    break;
                }

                case 3: {
                    printMenu();
                    break;
                }

                case 4: {
//                    printPlaylist();
                    break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - play next song\n" +
                "2 - play previous song\n" +
                "3 - print menu options\n" +
                "4 - print playlist");
    }

}
