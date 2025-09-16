import java.util.Scanner;

public class StudentGradeManagementSystem {
    private static Student[] students;
    private static int studentCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize system
        initializeSystem();
        
        // Welcome message
        System.out.println("=== WELCOME TO " + Student.getSchoolName().toUpperCase() + " ===");
        System.out.println("Student Grade Management System");
        
        // Main menu loop
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addMarksToStudent();
                    break;
                case 3:
                    generateStudentReport();
                    break;
                case 4:
                    viewAllStudents();
                    break;
                case 5:
                    viewTopPerformers();
                    break;
                case 6:
                    generateClassReport();
                    break;
                case 7:
                    manageSubjects();
                    break;
                case 8:
                    systemSettings();
                    break;
                case 9:
                    generateComparativeReports();
                    break;
                case 10:
                    running = false;
                    System.out.println("Thank you for using " + Student.getSchoolName() + " Grade Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSystem() {
        students = new Student[100]; // Max 100 students
        
        // Initialize some subjects
        new Subject("MATH101", "Mathematics", 4, "Dr. Smith");
        new Subject("ENG101", "English", 3, "Prof. Johnson");
        new Subject("SCI101", "Science", 4, "Dr. Brown");
        new Subject("HIST101", "History", 3, "Prof. Davis");
        new Subject("COMP101", "Computer Science", 4, "Dr. Wilson");
        new Subject("ART101", "Arts", 2, "Ms. Garcia");
        
        // Create some sample students for demonstration
        createSampleData();
    }

    private static void createSampleData() {
        // Create sample students
        Student student1 = new Student("Alice Johnson", "Class 10A");
        student1.addSubject("Mathematics");
        student1.addSubject("English");
        student1.addSubject("Science");
        student1.addMarks("Mathematics", 92.0);
        student1.addMarks("Mathematics", 88.0);
        student1.addMarks("English", 85.0);
        student1.addMarks("English", 90.0);
        student1.addMarks("Science", 94.0);
        students[studentCount++] = student1;

        Student student2 = new Student("Bob Smith", "Class 10A");
        student2.addSubject("Mathematics");
        student2.addSubject("English");
        student2.addSubject("History");
        student2.addMarks("Mathematics", 78.0);
        student2.addMarks("Mathematics", 82.0);
        student2.addMarks("English", 75.0);
        student2.addMarks("History", 88.0);
        students[studentCount++] = student2;

        Student student3 = new Student("Carol Davis", "Class 10B");
        student3.addSubject("Science");
        student3.addSubject("Computer Science");
        student3.addSubject("Mathematics");
        student3.addMarks("Science", 96.0);
        student3.addMarks("Computer Science", 98.0);
        student3.addMarks("Mathematics", 91.0);
        students[studentCount++] = student3;
    }

    private static void displayMainMenu() {
        System.out.println("\n=== STUDENT GRADE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add New Student");
        System.out.println("2. Add Marks to Student");
        System.out.println("3. Generate Student Report Card");
        System.out.println("4. View All Students");
        System.out.println("5. View Top Performers");
        System.out.println("6. Generate Class Report");
        System.out.println("7. Manage Subjects");
        System.out.println("8. System Settings");
        System.out.println("9. Generate Comparative Reports");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addNewStudent() {
        System.out.println("\n=== ADD NEW STUDENT ===");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();

        Student newStudent = new Student(name, className);
        students[studentCount++] = newStudent;

        System.out.println("Student added successfully!");
        System.out.println("Student ID: " + newStudent.getStudentId());

        // Ask to add subjects
        System.out.print("Do you want to add subjects now? (y/n): ");
        if (scanner.nextLine().toLowerCase().startsWith("y")) {
            addSubjectsToStudent(newStudent);
        }
    }

    private static void addSubjectsToStudent(Student student) {
        System.out.println("\nAvailable Subjects:");
        Subject.displayAllSubjects();

        System.out.print("How many subjects to add (max 6): ");
        int subjectCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < subjectCount && i < 6; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            String subjectName = scanner.nextLine();
            if (student.addSubject(subjectName)) {
                System.out.println("Subject added successfully.");
            } else {
                System.out.println("Failed to add subject (limit reached).");
            }
        }
    }

    private static void addMarksToStudent() {
        System.out.println("\n=== ADD MARKS TO STUDENT ===");
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student: " + student.getStudentName());
        System.out.println("Subjects: ");
        String[] subjects = student.getSubjects();
        for (int i = 0; i < subjects.length && subjects[i] != null; i++) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }

        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();
        System.out.print("Enter marks (0-100): ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        if (student.addMarks(subjectName, marks)) {
            System.out.println("Marks added successfully!");
        } else {
            System.out.println("Failed to add marks.");
        }
    }

    private static void generateStudentReport() {
        System.out.println("\n=== GENERATE STUDENT REPORT ===");
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = findStudentById(studentId);
        if (student != null) {
            student.generateReportCard();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");
        if (studentCount == 0) {
            System.out.println("No students registered.");
            return;
        }

        System.out.println("ID\tName\t\tClass\t\tGPA\tStatus");
        System.out.println("--\t----\t\t-----\t\t---\t------");
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                Student s = students[i];
                System.out.println(s.getStudentId() + "\t" + 
                                 s.getStudentName() + "\t\t" +
                                 s.getClassName() + "\t\t" +
                                 String.format("%.2f", s.getGpa()) + "\t" +
                                 (s.checkPromotionEligibility() ? "PASS" : "FAIL"));
            }
        }
    }

    private static void viewTopPerformers() {
        System.out.println("\n=== TOP PERFORMERS ===");
        System.out.print("Enter number of top performers to display: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Student[] topPerformers = Student.getTopPerformers(students, count);
        
        if (topPerformers.length == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("Rank\tID\tName\t\tClass\t\tPercentage\tGrade");
        System.out.println("----\t--\t----\t\t-----\t\t----------\t-----");
        for (int i = 0; i < topPerformers.length; i++) {
            Student s = topPerformers[i];
            double percentage = s.getOverallPercentage();
            System.out.println((i + 1) + "\t" + s.getStudentId() + "\t" + 
                             s.getStudentName() + "\t\t" +
                             s.getClassName() + "\t\t" +
                             String.format("%.2f", percentage) + "%\t\t" +
                             s.getLetterGrade(percentage));
        }
    }

    private static void generateClassReport() {
        System.out.println("\n=== GENERATE CLASS REPORT ===");
        Student.generateSchoolReport(students);
    }

    private static void manageSubjects() {
        System.out.println("\n=== MANAGE SUBJECTS ===");
        System.out.println("1. View All Subjects");
        System.out.println("2. Add New Subject");
        System.out.println("3. Find Subject by Code");
        System.out.println("4. Find Subjects by Instructor");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                Subject.displayAllSubjects();
                break;
            case 2:
                addNewSubject();
                break;
            case 3:
                findSubjectByCode();
                break;
            case 4:
                findSubjectsByInstructor();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addNewSubject() {
        System.out.println("\n=== ADD NEW SUBJECT ===");
        System.out.print("Enter subject code: ");
        String code = scanner.nextLine();
        System.out.print("Enter subject name: ");
        String name = scanner.nextLine();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();

        new Subject(code, name, credits, instructor);
        System.out.println("Subject added successfully!");
    }

    private static void findSubjectByCode() {
        System.out.print("Enter subject code: ");
        String code = scanner.nextLine();
        Subject subject = Subject.findSubjectByCode(code);
        if (subject != null) {
            subject.displaySubjectInfo();
        } else {
            System.out.println("Subject not found.");
        }
    }

    private static void findSubjectsByInstructor() {
        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine();
        Subject[] subjects = Subject.getSubjectsByInstructor(instructor);
        
        if (subjects.length == 0) {
            System.out.println("No subjects found for instructor: " + instructor);
        } else {
            System.out.println("Subjects taught by " + instructor + ":");
            for (Subject subject : subjects) {
                subject.displaySubjectInfo();
                System.out.println("---");
            }
        }
    }

    private static void systemSettings() {
        System.out.println("\n=== SYSTEM SETTINGS ===");
        System.out.println("1. Change School Name");
        System.out.println("2. Change Pass Percentage");
        System.out.println("3. View Current Settings");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new school name: ");
                String newName = scanner.nextLine();
                Student.setSchoolName(newName);
                System.out.println("School name updated successfully!");
                break;
            case 2:
                System.out.print("Enter new pass percentage: ");
                double newPercentage = scanner.nextDouble();
                scanner.nextLine();
                Student.setPassPercentage(newPercentage);
                System.out.println("Pass percentage updated successfully!");
                break;
            case 3:
                System.out.println("Current Settings:");
                System.out.println("School Name: " + Student.getSchoolName());
                System.out.println("Pass Percentage: " + Student.getPassPercentage() + "%");
                System.out.println("Total Students: " + Student.getTotalStudents());
                System.out.println("Total Subjects: " + Subject.getTotalSubjects());
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void generateComparativeReports() {
        System.out.println("\n=== COMPARATIVE REPORTS ===");
        System.out.println("1. Class-wise Performance");
        System.out.println("2. Subject-wise Analysis");
        System.out.println("3. Grade Distribution");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                generateClasswiseReport();
                break;
            case 2:
                generateSubjectwiseReport();
                break;
            case 3:
                generateGradeDistribution();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void generateClasswiseReport() {
        System.out.println("\n=== CLASS-WISE PERFORMANCE ===");
        // Group students by class and calculate averages
        String[] classes = getUniqueClasses();
        
        for (String className : classes) {
            if (className != null) {
                Student[] classStudents = getStudentsByClass(className);
                double classAverage = Student.calculateClassAverage(classStudents);
                System.out.println("Class: " + className);
                System.out.println("Students: " + classStudents.length);
                System.out.println("Average: " + String.format("%.2f", classAverage) + "%");
                System.out.println("---");
            }
        }
    }

    private static void generateSubjectwiseReport() {
        System.out.println("\n=== SUBJECT-WISE ANALYSIS ===");
        Subject[] allSubjects = Subject.getAllSubjects();
        
        for (Subject subject : allSubjects) {
            if (subject != null) {
                System.out.println("Subject: " + subject.getSubjectName());
                System.out.println("Instructor: " + subject.getInstructor());
                // Calculate average for this subject across all students
                double subjectAverage = calculateSubjectAverage(subject.getSubjectName());
                System.out.println("Average Score: " + String.format("%.2f", subjectAverage) + "%");
                System.out.println("---");
            }
        }
    }

    private static void generateGradeDistribution() {
        System.out.println("\n=== GRADE DISTRIBUTION ===");
        int[] gradeCounts = new int[5]; // A, B, C, D, F
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                double percentage = students[i].getOverallPercentage();
                String grade = students[i].getLetterGrade(percentage);
                
                switch (grade) {
                    case "A": gradeCounts[0]++; break;
                    case "B": gradeCounts[1]++; break;
                    case "C": gradeCounts[2]++; break;
                    case "D": gradeCounts[3]++; break;
                    case "F": gradeCounts[4]++; break;
                }
            }
        }
        
        String[] grades = {"A", "B", "C", "D", "F"};
        for (int i = 0; i < grades.length; i++) {
            double percentage = studentCount > 0 ? (double)gradeCounts[i]/studentCount*100 : 0;
            System.out.println("Grade " + grades[i] + ": " + gradeCounts[i] + 
                             " students (" + String.format("%.1f", percentage) + "%)");
        }
    }

    // Helper methods
    private static Student findStudentById(String studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getStudentId().equals(studentId)) {
                return students[i];
            }
        }
        return null;
    }

    private static String[] getUniqueClasses() {
        String[] classes = new String[studentCount];
        int classCount = 0;
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                String className = students[i].getClassName();
                boolean exists = false;
                for (int j = 0; j < classCount; j++) {
                    if (classes[j].equals(className)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    classes[classCount++] = className;
                }
            }
        }
        
        return classes;
    }

    private static Student[] getStudentsByClass(String className) {
        Student[] classStudents = new Student[studentCount];
        int count = 0;
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getClassName().equals(className)) {
                classStudents[count++] = students[i];
            }
        }
        
        // Resize array
        Student[] result = new Student[count];
        for (int i = 0; i < count; i++) {
            result[i] = classStudents[i];
        }
        
        return result;
    }

    private static double calculateSubjectAverage(String subjectName) {
        double total = 0.0;
        int count = 0;
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                String[] subjects = students[i].getSubjects();
                for (int j = 0; j < subjects.length && subjects[j] != null; j++) {
                    if (subjects[j].equalsIgnoreCase(subjectName)) {
                        double percentage = students[i].getOverallPercentage();
                        if (percentage > 0) {
                            total += percentage;
                            count++;
                        }
                        break;
                    }
                }
            }
        }
        
        return count > 0 ? total / count : 0.0;
    }
}