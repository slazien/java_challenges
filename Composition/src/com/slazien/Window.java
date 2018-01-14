package com.slazien;

public class Window {
    private int height;
    private int width;
    private boolean isClean;
    private boolean isOpen;

    public Window(int height, int width, boolean isClean, boolean isOpen) {
        this.height = height;
        this.width = width;
        this.isClean = isClean;
        this.isOpen = isOpen;
    }

    public void open() {
        isOpen = true;
        System.out.println("Opened window");
    }

    public void close() {
        isOpen = false;
        System.out.println("Closed window");
    }

    public void setClean(boolean clean) {
        isClean = clean;
        if (isClean) {
            System.out.println("Window is clean");
        } else {
            System.out.println("Window is dirty");
        }
    }
}
