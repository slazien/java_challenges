package com.slazien;

public class Hamburger {
    private String name;
    private String breadRollType;
    private String meat;
    private double price;
    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;
    private double additionsPrice;

    public Hamburger(String name, String breadRollType, String meat, double price) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
        this.additionsPrice = 0;
    }

    public double getPrice() {
        return price;
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
        System.out.println("Added " + name + ": " + price + "$");
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
        System.out.println("Added " + name + ": " + price + "$");
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
        System.out.println("Added " + name + ": " + price + "$");
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
        System.out.println("Added " + name + ": " + price + "$");
    }

    public double addAdditions() {

        System.out.println(this.name + " hamburger on a " +
        this.breadRollType + " roll with " + this.meat + ": " + this.price + "$");

        if(this.addition1Name != null) {
            this.additionsPrice += this.addition1Price;
        }

        if(this.addition2Name != null) {
            this.additionsPrice += this.addition2Price;
        }

        if(this.addition3Name != null) {
            this.additionsPrice += this.addition3Price;
        }

        if(this.addition4Name != null) {
            this.additionsPrice += this.addition4Price;
        }

        return this.additionsPrice;

    }

    public void priceBreakdown() {
        System.out.println("Base price: " + this.price + "$");

        if(this.addition1Name != null) {
            System.out.println(this.addition1Name + ": " + this.addition1Price + "$");
        }

        if(this.addition2Name != null) {
            System.out.println(this.addition2Name + ": " + this.addition2Price + "$");
        }

        if(this.addition3Name != null) {
            System.out.println(this.addition3Name + ": " + this.addition3Price + "$");
        }

        if(this.addition4Name != null) {
            System.out.println(this.addition4Name + ": " + this.addition4Price + "$");
        }

        System.out.println("Grand total: " + (this.price + this.additionsPrice) + "$");


    }
}

