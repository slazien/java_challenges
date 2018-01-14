package com.slazien;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "White", "Sausage", 3.56);
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.12);
        double price = hamburger.addAdditions();
        System.out.println("Total burger price: " + (price + hamburger.getPrice()) + "$");

        System.out.println("----------");

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);

        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
        healthyBurger.addAdditions();
        System.out.println("Total healthy burger price: " + healthyBurger.getPrice() + "$");

        System.out.println("----------");
        DeluxeBurger db = new DeluxeBurger();
        db.addAdditions();
        db.addHamburgerAddition1("Should not be able to do this", 51000);
    }
}
