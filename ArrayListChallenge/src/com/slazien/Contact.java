package com.slazien;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Contact createContact(String name, String number) {
        return new Contact(name, number);
    }
}
