package com.slazien;

public class Main {
    public static void main(String[] args) {
//        Player player = new Player();
//        player.fullName = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health: " + player.healthRemaining());
//
//        damage = 11;
//        player.health = 200;
//        player.loseHealth(damage);
//        System.out.println("Remaining health: " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Przemek", 500, "Sword");
        System.out.println("Initial heath is " + player.getHealth());
    }

}
