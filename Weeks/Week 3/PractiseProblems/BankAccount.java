/*Create a program that clearly demonstrates the difference between instance and static
members. */
public class BankAccount {
    // TODO: Create static variables:
    // - bankName (String) - same for all accounts
    // - totalAccounts (int) - count of all accounts created
    // - interestRate (double) - same rate for all accounts
    static String bankName;
    static int totalAccounts = 0;
    static double interestRate;

    // TODO: Create instance variables:
    // - accountNumber (String) - unique for each account
    // - accountHolder (String) - unique for each account
    // - balance (double) - unique for each account
    String accountNumber;
    String accountHolder;
    double balance;

    // TODO: Create constructor that:
    // - Initializes instance variables
    // - Increments totalAccounts counter
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++;
    }

    // TODO: Create static methods:
    // - setBankName(String name)
    // - setInterestRate(double rate)
    // - getTotalAccounts() - returns count
    // - displayBankInfo() - shows bank name and total accounts
    static void setBankName(String name) {
        bankName = name;
    }

    static void setInterestRate(double rate) {
        interestRate = rate;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // TODO: Create instance methods:
    // - deposit(double amount)
    // - withdraw(double amount)
    // - calculateInterest() - uses static interestRate
    // - displayAccountInfo()
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        // TODO: Set bank name and interest rate using static methods
        BankAccount.setBankName("My Bank");
        BankAccount.setInterestRate(5.0);

    // TODO: Create multiple BankAccount objects
    BankAccount account1 = new BankAccount("12345", "Alice", 1000.0);
    BankAccount account2 = new BankAccount("67890", "Bob", 2000.0);
    BankAccount account3 = new BankAccount("54321", "Charlie", 3000.0);

    // TODO: Show that static members are shared across all objects
    System.out.println("Bank Name: " + BankAccount.bankName);
    System.out.println("Total Accounts: " + BankAccount.totalAccounts);
    System.out.println("Interest Rate: " + BankAccount.interestRate);

    // TODO: Show that instance members are unique to each object
    System.out.println("Account 1 Holder: " + account1.accountHolder);
    System.out.println("Account 2 Holder: " + account2.accountHolder);
    System.out.println("Account 3 Holder: " + account3.accountHolder);

    // TODO: Demonstrate calling static methods with and without objects
    BankAccount.displayBankInfo();
    System.out.println("Total Accounts (via instance): " + account1.getTotalAccounts());

    }
}