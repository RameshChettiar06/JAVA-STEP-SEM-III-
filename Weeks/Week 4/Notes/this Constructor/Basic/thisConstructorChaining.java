
class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String phoneNumber;

    // Most comprehensive constructor (master constructor)
    public Person(String firstName, String lastName, int age, String email, String phoneNumber) {
        // Validation
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }

        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.age = age;
        this.email = (email != null && !email.trim().isEmpty()) ? email.trim() : "not.provided@email.com";
        this.phoneNumber = (phoneNumber != null && !phoneNumber.trim().isEmpty()) ? phoneNumber.trim() : "000-000-0000";

        System.out.println("Person created: " + this.firstName + " " + this.lastName);
    }

    // Constructor with name and age only
    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, null, null); // Chain to master constructor
    }

    // Constructor with names only (default age)
    public Person(String firstName, String lastName) {
        this(firstName, lastName, 0, null, null); // Chain to master constructor
    }

    // Helper used in full-name constructor — safe to call inside this(...)
    private static String[] splitFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Full name must contain at least first and last name");
        }
        String first = parts[0];
        String last = parts[parts.length - 1];
        return new String[] { first, last };
    }

    // Constructor with full name string
    public Person(String fullName, int age) {
        // call splitFullName(...) inside this(...) so no statements precede this(...)
        this(splitFullName(fullName)[0], splitFullName(fullName)[1], age, null, null);
    }

    // Default constructor
    public Person() {
        this("Unknown", "Person", 0, null, null); // Chain to master constructor
    }

    public void displayInfo() {
        System.out.println("Name: " + firstName + " " + lastName + ", Age: " + age
                + ", Email: " + email + ", Phone: " + phoneNumber);
    }
}


public class thisConstructorChaining {
    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 25, "john.doe@email.com", "123-456-7890");
        Person p2 = new Person("Jane", "Smith", 30);
        Person p3 = new Person("Bob", "Johnson");
        Person p4 = new Person("Alice Mary Johnson", 28);
        Person p5 = new Person();

        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();
        p5.displayInfo();
    }
}
