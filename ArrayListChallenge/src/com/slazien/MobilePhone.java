package com.slazien;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public void printContacts() {
        System.out.println("Available contacts: ");
        for(int i=0; i<this.contacts.size(); i++) {
            Contact currentContact = this.contacts.get(i);
            System.out.println(i+1 + ". " + currentContact.getName() + ": " + currentContact.getNumber());
        }
    }

    public boolean addContact(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact exists");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if(position >= 0) {
            this.contacts.set(position, newContact);
            System.out.println("Replaced " + oldContact.getName() + " with " + newContact.getName());
            return true;
        } else {
            System.out.println(oldContact.getName() + " not found!");
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if(position >= 0) {
            this.contacts.remove(position);
            System.out.println("Removed " + contact.getName());
            return true;
        } else {
            System.out.println("Contact " + contact.getName() + " not found!");
            return false;
        }
    }

    private int findContact(Contact contact) {
        int position = contacts.indexOf(contact);
        return position;
    }

    private int findContact(String name) {
        for(int i=0; i<this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if(contact.getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public String queryContact(Contact contact) {
        if(findContact(contact) >= 0) {
            return contact.getName();
        } else {
            return null;
        }
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return this.contacts.get(position);
        }

        return null;
    }
}
