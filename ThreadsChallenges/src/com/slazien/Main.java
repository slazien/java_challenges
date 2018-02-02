package com.slazien;

public class Main {

    public static void main(String[] args) {

        NewBankAccount account = new NewBankAccount("12345-678", 1000.00);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        });

        t1.start();
        t2.start();
    }
}
