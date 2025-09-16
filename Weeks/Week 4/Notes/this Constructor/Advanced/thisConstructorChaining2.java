// ...existing code...
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;
    private double interestRate;

    // Master constructor with all validation
    public BankAccount(String accountNumber, String accountHolder, double balance,
                       String accountType, double interestRate) {
        validateAccountNumber(accountNumber);
        validateAccountHolder(accountHolder);
        validateBalance(balance);
        validateAccountType(accountType);
        validateInterestRate(interestRate);

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.interestRate = interestRate;
        logAccountCreation();
    }

    // Savings account constructor
    public BankAccount(String accountHolder, double balance) {
        this(generateAccountNumber("SAV"), accountHolder, balance, "SAVINGS", 2.5);
    }

    // Checking account constructor
    public BankAccount(String accountHolder) {
        this(generateAccountNumber("CHK"), accountHolder, 0.0, "CHECKING", 0.1);
    }

    // Copy constructor (fixed - do not use this(...) with complex expressions)
    public BankAccount(BankAccount other) {
        if (other == null) {
            throw new IllegalArgumentException("Source account cannot be null");
        }

        // Validate source fields before copying
        validateAccountHolder(other.accountHolder);
        validateBalance(other.balance);
        validateAccountType(other.accountType);
        validateInterestRate(other.interestRate);

        // Generate a new account number for the copied account
        String prefix = other.accountType != null && other.accountType.length() >= 3
                ? other.accountType.substring(0, 3)
                : "ACC";
        this.accountNumber = generateAccountNumber(prefix);
        this.accountHolder = other.accountHolder;
        this.balance = other.balance;
        this.accountType = other.accountType;
        this.interestRate = other.interestRate;
        logAccountCreation();
    }

    // Basic operations
    public synchronized void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public String getAccountType() { return accountType; }
    public double getInterestRate() { return interestRate; }

    // Validation methods
    private void validateAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().length() < 5) {
            throw new IllegalArgumentException("Invalid account number");
        }
    }

    private void validateAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
    }

    private void validateBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

    private void validateAccountType(String accountType) {
        if (!"SAVINGS".equals(accountType) && !"CHECKING".equals(accountType)) {
            throw new IllegalArgumentException("Invalid account type");
        }
    }

    private void validateInterestRate(double interestRate) {
        if (interestRate < 0 || interestRate > 10) {
            throw new IllegalArgumentException("Interest rate must be between 0 and 10");
        }
    }

    private static String generateAccountNumber(String prefix) {
        return prefix + "-" + System.currentTimeMillis();
    }

    private void logAccountCreation() {
        System.out.println("Account created: " + accountNumber + " for " + accountHolder
                + " (" + accountType + ")");
    }

    @Override
    public String toString() {
        return String.format("BankAccount[number=%s, holder=%s, type=%s, balance=%.2f, rate=%.2f%%]",
                accountNumber, accountHolder, accountType, balance, interestRate);
    }
}

// Public driver class must match filename
public class thisConstructorChaining2 {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Alice Brown", 500.0);       // Savings
        BankAccount a2 = new BankAccount("Bob Smith");                // Checking
        BankAccount a3 = new BankAccount("ACC-12345", "Carol King", 1000.0, "SAVINGS", 3.0);

        a1.deposit(150.0);
        try { a2.withdraw(50.0); } catch (IllegalArgumentException e) { /* ignored for demo */ }

        BankAccount a4 = new BankAccount(a3); // copy

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        // demonstrate validations
        try {
            new BankAccount("", "Invalid", -10.0, "OTHER", 20.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected validation error: " + e.getMessage());
        }
    }
}
