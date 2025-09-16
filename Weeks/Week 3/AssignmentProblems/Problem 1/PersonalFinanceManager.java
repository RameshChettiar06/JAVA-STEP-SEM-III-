/*Create a personal finance management system to track income,
expenses, and savings for individuals. */

/*Create a PersonalAccount class with private attributes: accountHolderName
(String), accountNumber (String), currentBalance (double), totalIncome
(double), totalExpenses (double) */
class PersonalAccount{
    private String accountNumber;
    private String accountHolderName;
    private double currentBalance;
    private double totalExpenses;
    private double totalIncome;

    //Include static variables: totalAccounts (int), bankName (String)
    static int totalAccounts;
    static String bankName;

    // Constructor
    public PersonalAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
    }

    // Getter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    /*Implement methods: addIncome(double amount, String description),
    addExpense(double amount, String description), calculateSavings(),
    displayAccountSummary() */
    void addIncome(double amount, String description){
        totalIncome += amount;
        currentBalance += amount;
        System.out.println("Income Added: " + amount + " Description: " + description);
    }

    void addExpense(double amount, String description){
        totalExpenses += amount;
        currentBalance -= amount;
        System.out.println("Expense Added: " + amount + " Description: " + description);
    }

    double calculateSavings(){
        return totalIncome - totalExpenses;
    }

    void displayAccountSummary(){
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
    }

    /*Create static methods: setBankName(String name), getTotalAccounts(),
    generateAccountNumber() */
    static void setBankName(String name){
        bankName = name;
    }

    static int getTotalAccounts(){
        return totalAccounts;
    }

    static String generateAccountNumber(){
        totalAccounts++;
        return bankName + "-" + totalAccounts;
    }

}


public class PersonalFinanceManager{
    /*In the main method, create at least 3 different personal accounts, perform various
    transactions, and display account summaries */
    public static void main(String args[]) {
        // Set bank name
        PersonalAccount.setBankName("SRM Bank");

        // Create an array of 3 accounts
        PersonalAccount[] accounts = new PersonalAccount[3];
        String[] names = {"Ramesh", "Suresh", "Priya"};

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new PersonalAccount(names[i]);
        }

        // Perform transactions
        accounts[0].addIncome(10000, "Salary");
        accounts[0].addExpense(2500, "Rent");
        accounts[0].addExpense(1200, "Groceries");

        accounts[1].addIncome(15000, "Freelance Project");
        accounts[1].addExpense(3000, "Travel");
        accounts[1].addExpense(2000, "Shopping");

        accounts[2].addIncome(8000, "Part-time Job");
        accounts[2].addExpense(1000, "Books");
        accounts[2].addExpense(500, "Snacks");

        // Display account summaries
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("\nAccount Summary for " + accounts[i].getAccountHolderName() + ":");
            accounts[i].displayAccountSummary();
        }

        System.out.println("\nTotal Accounts Created: " + PersonalAccount.getTotalAccounts());
        System.out.println("Bank Name: " + PersonalAccount.bankName);

        /*Demonstrate the difference between static and instance variables by showing how
        bankName is shared across all accounts while individual balances are unique */
        System.out.println("\nDemonstrating Static vs Instance Variables:");
        System.out.println("Bank Name from accounts[0]: " + accounts[0].bankName);
        System.out.println("Bank Name from accounts[1]: " + accounts[1].bankName);
        System.out.println("Bank Name from accounts[2]: " + accounts[2].bankName);

        System.out.println("accounts[0] Balance: " + accounts[0].getCurrentBalance());
        System.out.println("accounts[1] Balance: " + accounts[1].getCurrentBalance());
        System.out.println("accounts[2] Balance: " + accounts[2].getCurrentBalance());
    }
}