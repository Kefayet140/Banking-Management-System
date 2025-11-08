
package com.mycompany.banking_management_system;

import java.util.ArrayList;

public class BankAccount {
    
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Successfully withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void showTransactions() {
        System.out.println("=== Transaction History ===");
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }
    public double getBalance() {
    return balance;
   }

   public ArrayList<Transaction> getTransactions() {
    return transactions;
    }

}
