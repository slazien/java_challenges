package com.slazien;

public class Main {
    public static void main(String[] args) {
        Wall wall1 = new Wall(100, 100, "blue", "rough");
        Wall wall2 = new Wall(100, 100, "green", "smooth");
        Wall wall3 = new Wall(100, 100, "red", "rough");
        Wall wall4 = new Wall(100, 100, "yellow", "rough");

        Cupboard cupboard = new Cupboard(80, 20, "brown", 4, 2);
        Window window = new Window(50, 20, true, false);

        Room room = new Room("Living room", cupboard, window, wall1, wall2, wall3, wall4);

        room.closeWindow();

        System.out.println("Cupboard has " + room.getCupboard().getDoors() + " doors");
    }
}
