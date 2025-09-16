class Student {
    private String name;
    private int age;
    private double gpa;

    // Parameterized constructor
    public Student(String studentName, int studentAge, double studentGPA) {
        // Initialize instance variables with parameter values
        name = studentName;
        age = studentAge;
        gpa = studentGPA;
        // Input validation example
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (studentGPA < 0.0 || studentGPA > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }

        // Initialize instance variables with validated values
        this.name = studentName;
        this.age = studentAge;
        this.gpa = studentGPA;
    }

    // Getter methods
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGPA() { return gpa; }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
    }
}

public class ParameterisedConstructor {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 20, 3.8);
        s1.displayInfo();

        try {
            // This will throw due to negative age
            Student s2 = new Student("Bob", -1, 3.0);
            s2.displayInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create student: " + e.getMessage());
        }

        try {
            // This will throw due to invalid GPA
            Student s3 = new Student("Carol", 19, 4.5);
            s3.displayInfo();
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create student: " + e.getMessage());
        }
    }
}