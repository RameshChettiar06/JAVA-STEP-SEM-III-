/*Write a program to create a Bank Account management system
without using built-in collection classes
 * a. Create a BankAccount class with private instance variables: accountNumber
(String), accountHolderName (String), balance (double), and a static variable
totalAccounts (int)
b. Create a constructor that takes account holder name and initial deposit,
automatically generates account number using a static counter
c. Create instance methods: deposit(double amount), withdraw(double amount),
checkBalance() with proper validation for negative amounts and insufficient funds
d. Create static methods: getTotalAccounts(), generateAccountNumber() that
returns a unique account number like "ACC001", "ACC002"
e. Create a method displayAccountInfo() to show all account details in a formatted
manner
f. In the main method, create an array of BankAccount objects, demonstrate
creating multiple accounts, performing transactions, and showing the difference
between static and instance variables
 */

public class BankAccount {
    // Private instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Static variable
    private static int totalAccounts = 0;
    private static int accountCounter = 0;

    // Constructor
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // Static method to generate unique account number
    private static String generateAccountNumber() {
        accountCounter++;
        return String.format("ACC%03d", accountCounter);
    }

    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Instance method to deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount must be positive.");
        }
    }

    // Instance method to withdraw
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Amount must be positive.");
        } else {
            System.out.println("Insufficient funds. Current balance: " + balance);
        }
    }

    // Instance method to check balance
    public double checkBalance() {
        return balance;
    }

    // Instance method to display account info
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("-----------------------------");
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create an array of BankAccount objects
        BankAccount[] accounts = new BankAccount[3];

        // Create multiple accounts
        accounts[0] = new BankAccount("Ramesh Chettiar", 1000.0);
        accounts[1] = new BankAccount("Shah Rukh Khan", 500.0);
        accounts[2] = new BankAccount("Vijay", 2000.0);

        // Display total accounts (static variable)
        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
        System.out.println();

        // Perform transactions on each account
        accounts[0].deposit(500.0);
        accounts[0].withdraw(200.0);
        accounts[0].displayAccountInfo();

        accounts[1].withdraw(600.0); // Should fail due to insufficient funds
        accounts[1].deposit(-100.0); // Should fail due to negative amount
        accounts[1].displayAccountInfo();

        accounts[2].withdraw(500.0);
        accounts[2].deposit(1000.0);
        accounts[2].displayAccountInfo();

        // Demonstrate static vs instance variables
        System.out.println("Total Accounts (static): " + BankAccount.getTotalAccounts());
        System.out.println("Balance of account 0 (instance): " + accounts[0].checkBalance());
        System.out.println("Balance of account 1 (instance): " + accounts[1].checkBalance());
        System.out.println("Balance of account 2 (instance): " + accounts[2].checkBalance());
    }
}
