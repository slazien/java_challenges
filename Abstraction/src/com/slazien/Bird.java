package com.slazien;

public abstract class Bird extends Animal implements ICanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");
    }


    @Override
    public void fly() {
        System.out.println(super.getName() + " is flapping its wings");
    }
}
