package com.Bankmanagement;

public class Transaction {
    private String description; // Description of the transaction
    private double amount; // Amount of the transaction

    // Constructor for Transaction
    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Method to get the description of the transaction
    public String getDescription() {
        return description;
    }

    // Method to get the amount of the transaction
    public double getAmount() {
        return amount;
    }
}
