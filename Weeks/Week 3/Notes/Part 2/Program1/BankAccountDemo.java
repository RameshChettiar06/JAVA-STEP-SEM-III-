// File: BankAccountDemo.java

// Demo class to test BankAccount functionality
public class BankAccountDemo {
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
        System.out.println("🔍 Current Balance: ₹" + currentBalance);

        // Show account summary
        myAccount.showAccountSummary("4321");

        // Attempt to access with wrong PIN
        myAccount.showAccountSummary("0000");
    }
}