package com.slazien;

public class Main {

    public static void main(String[] args) {
        Vehicle tractor = new Vehicle("Tractor", "Urusu", "yellow");
        Car porsche = new Car("Porsche", "911", "black", 600, "rear", 7, 1, false);
        Outlander ml = new Outlander("ML", "black", 300, 5, 1, true, 1);
        ml.accelerate(50);
        ml.changeVelocity(30, 90);
        Vehicle whatever = new Vehicle();
    }
}
