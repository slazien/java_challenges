package com.slazien;

public class Outlander extends Car{
    private boolean hasDifferentialLock;
    private int spareWheels;

    public Outlander(String name, String model, String color, int horsepower, String drive, int gears, int currentGear,
                     boolean isManual, boolean hasDifferentialLock, int spareWheels) {
        super(name, model, color, horsepower, drive, gears, currentGear, isManual);
        this.hasDifferentialLock = hasDifferentialLock;
        this.spareWheels = spareWheels;
    }

    public Outlander(String model, String color, int horsepower, int gears, int currentGear,
                     boolean hasDifferentialLock, int spareWheels) {
        this("Outlander", model, color, horsepower, "AWD", gears, currentGear, true, hasDifferentialLock, spareWheels);
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentSpeed() + rate;
        if(newVelocity == 0) {
            stop();
            setCurrentGear(1);
        } else if(newVelocity > 0 & newVelocity <= 20) {
            setCurrentGear(2);
        } else if(newVelocity > 20 & newVelocity <= 30) {
            setCurrentGear(3);
        } else if(newVelocity > 30 & newVelocity <= 40) {
            setCurrentGear(4);
        } else {
            setCurrentGear(5);
        }

        if(newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }

}
