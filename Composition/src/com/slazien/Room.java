package com.slazien;

public class Room {
    private String name;
    private Cupboard cupboard;
    private Window window;
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;

    public Room(String name, Cupboard cupboard, Window window, Wall wall1, Wall wall2, Wall wall3, Wall wall4) {
        this.name = name;
        this.cupboard = cupboard;
        this.window = window;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.wall4 = wall4;
    }

    public void openWindow() {
        window.open();
    }

    public void closeWindow() {
        window.close();
    }

    public Cupboard getCupboard() {
        return cupboard;
    }

}
