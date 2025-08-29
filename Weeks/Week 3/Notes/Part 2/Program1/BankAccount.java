// File: BankAccountDemo.java

// Class representing a secure bank account
public class BankAccount {
    // Private data - cannot be accessed directly from outside
    private double balance;
    private String accountNumber;
    private String pin;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        System.out.println(" Account " + accountNumber + " created with balance ₹" + initialBalance);
    }

    // Controlled access through public methods
    public boolean withdraw(double amount, String enteredPin) {
        // Security validation
        if (!validatePin(enteredPin)) {
            System.out.println(" Invalid PIN!");
            return false;
        }
        if (amount > balance) {
            System.out.println(" Insufficient funds!");
            return false;
        }
        balance -= amount;
        System.out.println(" Withdrawal of ₹" + amount + " successful.");
        return true;
    }

    // Deposit method - adds money to account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposited ₹" + amount + " successfully.");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    // Private method - internal implementation hidden
    private boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    // Read-only access to balance
    public double getBalance(String enteredPin) {
        if (validatePin(enteredPin)) {
            return balance;
        }
        System.out.println(" Invalid PIN! Cannot retrieve balance.");
        return -1; // Invalid access
    }

    // Display account summary (limited info)
    public void showAccountSummary(String enteredPin) {
        if (validatePin(enteredPin)) {
            System.out.println(" Account Summary:");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: ₹" + balance);
        } else {
            System.out.println(" Access denied. Invalid PIN.");
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        System.out.println("=== Bank Account Simulation ===\n");

        // Creating a new account
        BankAccount myAccount = new BankAccount("ACC123456", "4321", 5000.0);

        // Trying to withdraw with wrong PIN
        myAccount.withdraw(1000, "1234");

        // Correct withdrawal
        myAccount.withdraw(1000, "4321");

        // Deposit money
        myAccount.deposit(2000);

        // Check balance with correct PIN
        double currentBalance = myAccount.getBalance("4321");
        System.out.println(" Current Balance: ₹" + currentBalance);

        // Show account summary
        myAccount.showAccountSummary("4321");

        // Attempt to access with wrong PIN
        myAccount.showAccountSummary("0000");
    }
}