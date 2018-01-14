package com.slazien;

public class Vehicle {
    private String name;
    private String model;
    private String color;

    private int currentSpeed;
    private int currentDirection;

    public Vehicle(String name, String model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.currentSpeed = 0;
        this.currentDirection = 0;
    }

    public Vehicle() {
        this("Default name", "Default model", "Default color");
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Current direction: " + currentDirection);
    }

    public void move(int speed, int direction) {
        this.currentSpeed = speed;
        this.currentDirection = direction;
        System.out.println("Moving at direction " + currentDirection + " at speed " + currentSpeed);
    }

    public void stop() {
        setCurrentSpeed(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
