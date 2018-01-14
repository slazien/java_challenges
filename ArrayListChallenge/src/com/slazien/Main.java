package com.slazien;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("666 777 888");

    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        printInstructions();

        while(!quit) {
            System.out.println("Enter your choice: (0 to list options)");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0: {
                    printInstructions();
                    break;
                }
                case 1: {
                    printContacts();
                    break;
                }
                case 2: {
                    addContact();
                    break;
                }
                case 3: {
                    updateContact();
                    break;
                }
                case 4: {
                    removeContact();
                    break;
                }
                case 5: {
                    queryContact();
                    break;
                }
                case 6: {
                    quit = true;
                    break;
                }
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To query a contact.");
        System.out.println("\t 6 - To quit");
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if(mobilePhone.addContact(newContact)) {
            System.out.println("New contact added: " + newContact.getName() + ", " + newContact.getNumber());
        } else {
            System.out.println("Contact " + newContact.getName() + " already exists!");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.queryContact(name);
        if(oldContact == null) {
            System.out.println("Contact " + name + " doesn't exist!");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(oldContact, newContact)) {
            System.out.println("Updated contact: " + oldContact.getName() + " -> " + newContact.getName());
        } else {
            System.out.println("Contact " + oldContact.getName() + " not found!");
        }
    }

    private static void removeContact() {
        System.out.println("Enter contact name to remove: ");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.queryContact(name);
        if(oldContact == null) {
            System.out.println("Contact " + name + " doesn't exist!");
        }

        mobilePhone.removeContact(oldContact);
        System.out.println("Removed contact " + oldContact.getName());
    }

    private static void queryContact() {
        System.out.println("Enter contact name to query: ");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.queryContact(name);
        if(oldContact == null) {
            System.out.println("Contact " + name + " doesn't exist!");
            return;
        }

        System.out.println("Contact name: " + oldContact.getName() + ", number: " + oldContact.getNumber());
    }
}
