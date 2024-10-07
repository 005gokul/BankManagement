package com.Bankmanagement;

import java.util.HashMap;
import java.util.Map;

public class User {

    // A map to store username and password
    private static Map<String, String> userDatabase = new HashMap<>();
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Sign up function to add a new user
    public static boolean signUp(String username, String password) {
        if (!userDatabase.containsKey(username)) {
            userDatabase.put(username, password);
            System.out.println("User signed up successfully!");
            return true;
        } else {
            System.out.println("Username already exists. Try a different one.");
            return false;
        }
    }

    // Login function to authenticate a user
    public static boolean login(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
