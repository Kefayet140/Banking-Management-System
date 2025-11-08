
package com.mycompany.banking_management_system;

public class Transaction {
    
private String type; 
private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public void displayTransaction() {
        System.out.println(type + " of amount: " + amount);
    }
    public String getType() {
    return type;
}

public double getAmount() {
    return amount;
}

}