package com.slazien;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("12345", 0.00, "Bob Brown", "bob@gmail.com", "0 123 456");
        acc.deposit(1000);
        acc.withdraw(500);
        System.out.println(acc.getEmail());
    }
}
