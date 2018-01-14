package com.slazien;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public VipCustomer() {
        this("Default name", 10000.0, "default.email@domain.com");
    }

    public VipCustomer(String name, double limit) {
        this(name, limit, "default.email@domain.com");
    }

    public VipCustomer(String name, double limit, String email) {
        this.name = name;
        this.creditLimit = limit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
