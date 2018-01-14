package com.slazien;

public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;
    private double healthyAdditionsPrice;

    public HealthyBurger(String meat, double price) {
        super("Healthy", "Brown rye", meat, price);
        this.healthyAdditionsPrice = 0;
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double addAdditions() {
        healthyAdditionsPrice = super.addAdditions();

        if(this.healthyExtra1Name != null) {
            healthyAdditionsPrice += this.healthyExtra1Price;
            System.out.println("Added " + this.healthyExtra1Name + ": " + this.healthyExtra1Price + "$");
        }
        if(this.healthyExtra2Name != null) {
            healthyAdditionsPrice += this.healthyExtra2Price;
            System.out.println("Added " + this.healthyExtra2Name + ": " + this.healthyExtra2Price + "$");
        }

        return healthyAdditionsPrice;
    }

    @Override
    public double getPrice() {
        return (super.getPrice() + this.healthyAdditionsPrice);
    }
}
