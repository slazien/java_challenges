package com.slazien;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("HSBC");
        bank.addBranch("London");
        bank.addCustomer("Przemek", 100.6, "London");
        bank.addCustomer("Slawek", 500.45, "London");
        bank.addCustomer("Kasia", 400.1, "London");

        bank.addBranch("Southampton");
        bank.addCustomer("Mateusz", 42.0, "Southampton");
        bank.addCustomerTransaction("Przemek", 300, "London");

        bank.listCustomers("London", true);

        if(!bank.addCustomer("Babcia", 559.24, "Warsaw")){
            System.out.println("Branch Warsaw does not exist");
        }

        if(!bank.addBranch("London")) {
            System.out.println("Branch London already exists");
        }

        if(!bank.addCustomerTransaction("London", 23, "Kasia")) {
            System.out.println("Customer does not exist at branch");
        }
    }
}
