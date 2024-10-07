package com.Bankmanagement;

import java.util.ArrayList;

public class Account {
    private int accountNumber; // Unique account number
    private double balance; // Current balance
    private ArrayList<Transaction> transactions; // List to hold transaction history

    // Constructor to initialize the account
    public Account(int accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        transactions.add(new Transaction("Initial Deposit", initialDeposit)); // Add initial deposit to transactions
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount; // Increase balance
        transactions.add(new Transaction("Deposit", amount)); // Log transaction
        System.out.println("Deposited " + amount + " successfully.");
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount; // Decrease balance
            transactions.add(new Transaction("Withdrawal", amount)); // Log transaction
            System.out.println("Withdrawal of " + amount + " successful.");
        } else {
            System.out.println("Insufficient balance."); // Error for insufficient funds
        }
    }

    // Method to print a mini statement of transactions
    public void printMiniStatement() {
        System.out.println("Mini Statement for Account Number: " + accountNumber);
        for (Transaction t : transactions) {
            System.out.println(t.getDescription() + ": " + t.getAmount());
        }
        System.out.println("Current Balance: " + balance); // Show current balance
    }

    // Method to get the current balance
    public double getBalance() {
        return balance; // Return the balance
    }
}
