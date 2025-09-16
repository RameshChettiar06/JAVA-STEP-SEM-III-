import java.util.Random;

public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Default constructor → balance = 0
    public BankAccount() {
        this("Unknown", 0, 0);
    }

    // Constructor with name → assigns random account number
    public BankAccount(String accountHolder) {
        this(accountHolder, generateAccountNumber(), 0);
    }

    // Constructor with name and initial balance → assigns both
    public BankAccount(String accountHolder, double initialBalance) {
        this(accountHolder, generateAccountNumber(), initialBalance);
    }

    // Full constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Generate random account number
    private static int generateAccountNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); // 6-digit account number
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited to " + accountHolder + "'s account.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn from " + accountHolder + "'s account.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display account info
    public void displayAccount() {
        System.out.println("----------- Bank Account -----------");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("-----------------------------------");
    }
}
