package com.slazien;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public boolean deposit(double amount) {
        boolean status = false; // local variable, stored in thread stack, no need to synchronize

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    this.balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Thread " + Thread.currentThread().getName() + " could not get the lock!");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted!");
        }

        System.out.println("Transaction status: " + status);

        return status;
    }

    public void withdraw(double amount) {
        boolean status = false; // local variable, stored in thread stack, no need to synchronize

        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    this.balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Thread " + Thread.currentThread().getName() + " could not get the lock!");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " interrupted!");
        }

        System.out.println("Transaction status: " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + this.accountNumber);
    }
}