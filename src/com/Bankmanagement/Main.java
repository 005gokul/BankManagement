package com.Bankmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			Bank bank = new Bank();
			User loggedInUser = null;
			
			System.out.println("Welcome to the Bank Management System!");

			boolean loggedIn = false;
			boolean signedUp = false;
			while (!loggedIn) {
			    System.out.println("\n1. Sign Up");
			    System.out.println("2. Login");
			    System.out.println("3. Exit");
			    System.out.print("Choose an option: ");
			    int loginChoice = sc.nextInt();

			    switch (loginChoice) {
			        case 1:
			            // Signup flow
			            System.out.print("Enter a username: ");
			            String usernameSignup = sc.next();
			            System.out.print("Enter a password: ");
			            String passwordSignup = sc.next();
			            signedUp = User.signUp(usernameSignup, passwordSignup);
			            
			            if (signedUp) {
			                // After signup, return to login screen
			                System.out.println("Please login to continue.");
			            }
			            break;
			        case 2:
			            // Login flow
			            System.out.print("Enter your username: ");
			            String usernameLogin = sc.next();
			            System.out.print("Enter your password: ");
			            String passwordLogin = sc.next();
			            loggedIn = User.login(usernameLogin, passwordLogin);
			            
			            if (loggedIn) {
			                // Set logged in user after successful login
			                loggedInUser = new User(usernameLogin, passwordLogin);
			                bank.setLoggedInUser(loggedInUser);
			                System.out.println("Login successful! You can now perform bank operations.");
			            }
			            break;
			        case 3:
			            // Exit the program
			            System.out.println("Exiting. Thank you for using the system.");
			            return; // Ends the program
			        default:
			            System.out.println("Invalid option. Try again.");
			    }
			}

			// Bank operations after login
    // Bank operations after login
			boolean exit = false;
			while (!exit && loggedIn) {
			    System.out.println("\n1. Create Account");
			    System.out.println("2. Deposit");
			    System.out.println("3. Withdraw");
			    System.out.println("4. Mini Statement");
			    System.out.println("5. Check Balance");  // New Option for Checking Balance
			    System.out.println("6. Logout");
			    System.out.print("Choose an option: ");
			    int choice = sc.nextInt();

			    switch (choice) {
			        case 1:
			            System.out.print("Enter account holder's name: ");
			            String name = sc.next();
			            System.out.print("Enter initial deposit: ");
			            double initialDeposit = sc.nextDouble();
			            bank.createAccount(name, initialDeposit);
			            break;
			        case 2:
			            System.out.print("Enter account number: ");
			            int accNo = sc.nextInt();
			            System.out.print("Enter deposit amount: ");
			            double deposit = sc.nextDouble();
			            bank.deposit(accNo, deposit);
			            break;
			        case 3:
			            System.out.print("Enter account number: ");
			            int accNoWithdraw = sc.nextInt();
			            System.out.print("Enter withdrawal amount: ");
			            double withdrawal = sc.nextDouble();
			            bank.withdraw(accNoWithdraw, withdrawal);
			            break;
			        case 4:
			            System.out.print("Enter account number: ");
			            int accNoMiniStatement = sc.nextInt();
			            bank.printMiniStatement(accNoMiniStatement);
			            break;
			        case 5:
			            System.out.print("Enter account number: ");
			            int accNoBalance = sc.nextInt();
			            bank.checkBalance(accNoBalance);  // Call the new checkBalance method
			            break;
			        case 6:
			            System.out.println("Logging out...");
			            loggedIn = false;
			            loggedInUser = null;
			            break;
			        default:
			            System.out.println("Invalid option. Try again.");
			    }
			}
		}
    }
}