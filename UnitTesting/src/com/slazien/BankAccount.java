package com.slazien;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // Branch arg is true if the customer is performing the transaction at
    // a branch, with a teller.
    // It's false if the customer if performing the transaction at the ATM
    public double deposit(double amount, boolean branch) {
        this.balance += amount;
        return this.balance;
    }

    public double withdraw(double amount, boolean branch) {
        if(amount > 500 && !branch) {
            throw new IllegalArgumentException();
        }
        this.balance -= amount;
        return this.balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return this.accountType == CHECKING;
    }

    // More methods that use instance variables

}
