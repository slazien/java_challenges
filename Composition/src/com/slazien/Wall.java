package com.slazien;

public class Wall {
    private int height;
    private int width;
    private String color;
    private String texture;

    public Wall(int height, int width, String color, String texture) {
        this.height = height;
        this.width = width;
        this.color = color;
        this.texture = texture;
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

    public String getTexture() {
        return texture;
    }
}
