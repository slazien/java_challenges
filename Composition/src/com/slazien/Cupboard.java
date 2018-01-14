package com.slazien;

public class Cupboard {
    private int height;
    private int width;
    private String color;
    private int shelves;
    private int doors;

    public Cupboard(int height, int width, String color, int shelves, int doors) {
        this.height = height;
        this.width = width;
        this.color = color;
        this.shelves = shelves;
        this.doors = doors;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getShelves() {
        return shelves;
    }

    public int getDoors() {
        return doors;
    }
}
