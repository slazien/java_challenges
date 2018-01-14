package com.slazien;

public class Car extends Vehicle {

    private int horsepower;
    private String drive;
    private int gears;
    private int currentGear;
    private boolean isManual;

    public Car(String name, String model, String color, int horsepower, String drive, int gears, int currentGear, boolean isManual) {
        super(name, model, color);
        this.horsepower = horsepower;
        this.drive = drive;
        this.gears = gears;
        this.currentGear = currentGear;
        this.isManual = isManual;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Gear changed to " + currentGear);
    }

    public void changeVelocity(int speed, int direction) {
        move(speed, direction);
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getDrive() {
        return drive;
    }

    public int getGears() {
        return gears;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public boolean isManual() {
        return isManual;
    }
}
