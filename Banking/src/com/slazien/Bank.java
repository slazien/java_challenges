package com.slazien;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if(branch == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addCustomer(String customerName, double transaction, String branchName) {
        Branch branch = findBranch(branchName);

        if(branch != null) {
            return branch.addCustomer(customerName, transaction);
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction, String branchName) {
        Branch branch = findBranch(branchName);

        if(branch != null) {
            return branch.addTransaction(customerName, transaction);
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if(branch.getName().equals(branchName)) {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customers in branch " + branch.getName());
            ArrayList<Customer> customers = branch.getCustomers();
            for(int i=0; i<customers.size(); i++) {
                Customer branchCustomer = customers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(showTransactions){
                    System.out.println("Transactions: ");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j=0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount: " + transactions.get(j));
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
