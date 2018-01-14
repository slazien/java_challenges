package com.slazien;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String name, double transaction) {
        if(findCustomer(name) == null) {
            this.customers.add(new Customer(name, transaction));
            return true;
        }

        return false;
    }

    public boolean addTransaction(String name, double amount) {
        Customer customer = findCustomer(name);

        if(customer != null) {
            customer.addTransaction(amount);
            return true;
        }

        return false;
    }

    private Customer findCustomer(String name) {
        for(int i=0; i<this.customers.size(); i++) {
            Customer customer = this.customers.get(i);

            if(customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }
}
