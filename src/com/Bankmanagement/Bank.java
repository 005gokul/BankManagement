package com.Bankmanagement;

import java.util.HashMap;
import java.util.Map;


public class Bank {
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private int nextAccountNumber = 1;

    public void setLoggedInUser(User user) {
    }

    // Method to create a new account
    public void createAccount(String name, double initialDeposit) {
        Account account = new Account(nextAccountNumber, name, initialDeposit);
        accounts.put(nextAccountNumber, account);
        System.out.println("Account created successfully! Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    // Method to deposit money into an account
    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money from an account
    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to print the mini statement
    public void printMiniStatement(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.printMiniStatement();
        } else {
            System.out.println("Account not found.");
        }
    }

    // New method to check the balance
    public void checkBalance(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("The balance for Account Number " + accountNumber + " is: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
