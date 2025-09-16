public class Program2 {
    public static void main(String[] args) {
        // Creating accounts using different constructors
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount("Ramesh Chettiar");
        BankAccount account3 = new BankAccount("Alice", 5000);

        // Deposit and Withdraw operations
        account1.deposit(1000);
        account2.deposit(2000);
        account3.withdraw(1000);
        account3.withdraw(6000); // Invalid attempt

        // Display account info
        account1.displayAccount();
        account2.displayAccount();
        account3.displayAccount();
    }
}
