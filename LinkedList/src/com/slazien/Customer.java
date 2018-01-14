package com.slazien;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double transaction) {
        this.name = name;
        addTransaction(transaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(Double transaction) {
        transactions.add(transaction);
        System.out.println("Added transaction with amount: " + transaction);
    }


}
