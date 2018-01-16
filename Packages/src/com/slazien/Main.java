package com.slazien;

import javax.xml.soap.Node;


public class Main {

    public static void main(String[] args) {
        Node node = null;
        org.w3c.dom.Node anotherNode = null; // no error due to conflicting package name "Node"
    }
}
