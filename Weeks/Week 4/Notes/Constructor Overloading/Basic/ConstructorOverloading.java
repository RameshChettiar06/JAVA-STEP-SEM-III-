// ...existing code...
class Employee {
    private String name;
    private int employeeId;
    private String department;
    private double salary;
    private String email;

    // Default constructor
    public Employee() {
        this.name = "Unknown";
        this.employeeId = 0;
        this.department = "Unassigned";
        this.salary = 0.0;
        this.email = "not.provided@company.com";
        System.out.println("Employee created with default values");
    }

    // Constructor with name and ID only
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = "Unassigned";
        this.salary = 0.0;
        this.email = generateEmail(name);
        System.out.println("Employee created with basic info");
    }

    // Constructor with name, ID, and department
    public Employee(String name, int employeeId, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = 0.0;
        this.email = generateEmail(name);
        System.out.println("Employee created with department info");
    }

    // Full constructor with all parameters
    public Employee(String name, int employeeId, String department, double salary, String email) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
        this.email = email;
        System.out.println("Employee created with full information");
    }

    // Constructor with different parameter order (overloading example)
    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.department = "General";
        this.email = generateEmail(name);
        System.out.println("Employee created with ID-first constructor");
    }

    // Helper method
    private String generateEmail(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "not.provided@company.com";
        }
        return name.toLowerCase().replace(" ", ".") + "@company.com";
    }

    // Display method
    public void displayInfo() {
        System.out.println("Employee: " + name + " (ID: " + employeeId + "), Dept: " + department
                + ", Salary: $" + salary + ", Email: " + email);
    }
}

public class ConstructorOverloading {
    public static void main(String[] args) {
        // Different ways to create Employee objects
        Employee emp1 = new Employee(); // Default constructor
        Employee emp2 = new Employee("John Doe", 1001); // Name and ID
        Employee emp3 = new Employee("Jane Smith", 1002, "Engineering"); // With department
        Employee emp4 = new Employee("Bob Johnson", 1003, "Marketing", 75000.0, "bob.j@company.com"); // Full
        Employee emp5 = new Employee(1004, "Alice Brown", 80000.0); // Different parameter order

        // Display all employees
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
        emp4.displayInfo();
        emp5.displayInfo();
    }
}
// ...existing