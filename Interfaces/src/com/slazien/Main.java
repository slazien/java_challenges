package com.slazien;

public class Main {

    public static void main(String[] args) {

        ITelephone timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(12345);
        timsPhone.powerOn();
        timsPhone.callPhone(12345);
        timsPhone.answer();
    }
}
