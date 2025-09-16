/*Create a comprehensive student grade management system for a school.
 * Create a Student class with attributes: studentId (String), studentName (String),
className (String), subjects (String array), marks (double 2D array), gpa (double)
● Include static variables: totalStudents (int), schoolName (String), gradingScale
(String array), passPercentage (double)
● Create a Subject class with: subjectCode (String), subjectName (String), credits
(int), instructor (String)
● Implement methods: addMarks(String subject, double marks),
calculateGPA(), generateReportCard(), checkPromotionEligibility()
● Create static methods: setGradingScale(),
calculateClassAverage(Student[] students),
getTopPerformers(Student[] students, int count),
generateSchoolReport()
● Include grade categorization (A, B, C, D, F) based on percentage ranges
● Create a system to handle multiple classes and generate comparative reports
 */

class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; // [subject][assessment] - multiple assessments per subject
    private double gpa;
    private int subjectCount;

    // Static variables
    private static int totalStudents = 0;
    private static String schoolName = "SRM International School";
    private static String[] gradingScale = {"A", "B", "C", "D", "F"};
    private static double passPercentage = 50.0;
    private static int studentCounter = 0;

    // Constructor
    public Student(String studentName, String className) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.className = className;
        this.subjects = new String[6]; // Max 6 subjects
        this.marks = new double[6][5]; // Max 5 assessments per subject
        this.gpa = 0.0;
        this.subjectCount = 0;
        totalStudents++;
    }

    // Generate unique student ID
    private static String generateStudentId() {
        studentCounter++;
        return "STU" + String.format("%04d", studentCounter);
    }

    // Add subject
    public boolean addSubject(String subjectName) {
        if (subjectCount < subjects.length) {
            subjects[subjectCount] = subjectName;
            subjectCount++;
            return true;
        }
        return false;
    }

    // Add marks for a specific subject and assessment
    public boolean addMarks(String subject, double markValue) {
        int subjectIndex = findSubjectIndex(subject);
        if (subjectIndex == -1) {
            System.out.println("Subject not found: " + subject);
            return false;
        }

        // Find next available assessment slot
        for (int i = 0; i < marks[subjectIndex].length; i++) {
            if (marks[subjectIndex][i] == 0.0) { // Assuming 0.0 means no mark
                marks[subjectIndex][i] = markValue;
                calculateGPA();
                return true;
            }
        }
        System.out.println("All assessment slots full for subject: " + subject);
        return false;
    }

    // Find subject index
    private int findSubjectIndex(String subject) {
        for (int i = 0; i < subjectCount; i++) {
            if (subjects[i] != null && subjects[i].equalsIgnoreCase(subject)) {
                return i;
            }
        }
        return -1;
    }

    // Calculate GPA
    public void calculateGPA() {
        double totalGradePoints = 0.0;
        int totalSubjects = 0;

        for (int i = 0; i < subjectCount; i++) {
            double subjectAverage = getSubjectAverage(i);
            if (subjectAverage > 0) {
                totalGradePoints += convertToGradePoint(subjectAverage);
                totalSubjects++;
            }
        }

        this.gpa = totalSubjects > 0 ? totalGradePoints / totalSubjects : 0.0;
    }

    // Get average marks for a subject
    private double getSubjectAverage(int subjectIndex) {
        double total = 0.0;
        int count = 0;

        for (int i = 0; i < marks[subjectIndex].length; i++) {
            if (marks[subjectIndex][i] > 0) {
                total += marks[subjectIndex][i];
                count++;
            }
        }

        return count > 0 ? total / count : 0.0;
    }

    // Convert percentage to grade point
    private double convertToGradePoint(double percentage) {
        if (percentage >= 90) return 4.0; // A
        else if (percentage >= 80) return 3.0; // B
        else if (percentage >= 70) return 2.0; // C
        else if (percentage >= 60) return 1.0; // D
        else return 0.0; // F
    }

    // Get letter grade from percentage
    public String getLetterGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }

    // Generate report card
    public void generateReportCard() {
        System.out.println("\n=== REPORT CARD ===");
        System.out.println("School: " + schoolName);
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Class: " + className);
        System.out.println("------------------------");

        double overallTotal = 0.0;
        int validSubjects = 0;

        for (int i = 0; i < subjectCount; i++) {
            double subjectAverage = getSubjectAverage(i);
            if (subjectAverage > 0) {
                String grade = getLetterGrade(subjectAverage);
                System.out.println(subjects[i] + ": " + String.format("%.2f", subjectAverage) + "% (" + grade + ")");
                overallTotal += subjectAverage;
                validSubjects++;
            }
        }

        double overallPercentage = validSubjects > 0 ? overallTotal / validSubjects : 0.0;
        System.out.println("------------------------");
        System.out.println("Overall Percentage: " + String.format("%.2f", overallPercentage) + "%");
        System.out.println("GPA: " + String.format("%.2f", gpa));
        System.out.println("Grade: " + getLetterGrade(overallPercentage));
        System.out.println("Status: " + (checkPromotionEligibility() ? "PROMOTED" : "NOT PROMOTED"));
    }

    // Check promotion eligibility
    public boolean checkPromotionEligibility() {
        for (int i = 0; i < subjectCount; i++) {
            double subjectAverage = getSubjectAverage(i);
            if (subjectAverage > 0 && subjectAverage < passPercentage) {
                return false;
            }
        }
        return true;
    }

    // Get overall percentage
    public double getOverallPercentage() {
        double total = 0.0;
        int validSubjects = 0;

        for (int i = 0; i < subjectCount; i++) {
            double subjectAverage = getSubjectAverage(i);
            if (subjectAverage > 0) {
                total += subjectAverage;
                validSubjects++;
            }
        }

        return validSubjects > 0 ? total / validSubjects : 0.0;
    }

    // Static method to set grading scale
    public static void setGradingScale(String[] newScale) {
        gradingScale = newScale;
    }

    // Static method to calculate class average
    public static double calculateClassAverage(Student[] students) {
        double total = 0.0;
        int count = 0;

        for (Student student : students) {
            if (student != null) {
                total += student.getOverallPercentage();
                count++;
            }
        }

        return count > 0 ? total / count : 0.0;
    }

    // Static method to get top performers
    public static Student[] getTopPerformers(Student[] students, int count) {
        if (students == null || count <= 0) return new Student[0];

        // Simple bubble sort for top performers
        Student[] sortedStudents = new Student[students.length];
        int validCount = 0;

        // Copy valid students
        for (Student student : students) {
            if (student != null) {
                sortedStudents[validCount++] = student;
            }
        }

        // Sort by overall percentage (descending)
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - 1 - i; j++) {
                if (sortedStudents[j].getOverallPercentage() < sortedStudents[j + 1].getOverallPercentage()) {
                    Student temp = sortedStudents[j];
                    sortedStudents[j] = sortedStudents[j + 1];
                    sortedStudents[j + 1] = temp;
                }
            }
        }

        // Return top count students
        int returnCount = Math.min(count, validCount);
        Student[] topPerformers = new Student[returnCount];
        for (int i = 0; i < returnCount; i++) {
            topPerformers[i] = sortedStudents[i];
        }

        return topPerformers;
    }

    // Static method to generate school report
    public static void generateSchoolReport(Student[] students) {
        System.out.println("\n=== SCHOOL REPORT ===");
        System.out.println("School: " + schoolName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Pass Percentage: " + passPercentage + "%");

        if (students == null || students.length == 0) {
            System.out.println("No students data available.");
            return;
        }

        double classAverage = calculateClassAverage(students);
        System.out.println("Class Average: " + String.format("%.2f", classAverage) + "%");

        // Count students by grade
        int[] gradeCounts = new int[5]; // A, B, C, D, F
        int promoted = 0;

        for (Student student : students) {
            if (student != null) {
                double percentage = student.getOverallPercentage();
                String grade = student.getLetterGrade(percentage);
                
                switch (grade) {
                    case "A": gradeCounts[0]++; break;
                    case "B": gradeCounts[1]++; break;
                    case "C": gradeCounts[2]++; break;
                    case "D": gradeCounts[3]++; break;
                    case "F": gradeCounts[4]++; break;
                }

                if (student.checkPromotionEligibility()) {
                    promoted++;
                }
            }
        }

        System.out.println("\nGrade Distribution:");
        System.out.println("A: " + gradeCounts[0] + " students");
        System.out.println("B: " + gradeCounts[1] + " students");
        System.out.println("C: " + gradeCounts[2] + " students");
        System.out.println("D: " + gradeCounts[3] + " students");
        System.out.println("F: " + gradeCounts[4] + " students");
        System.out.println("\nPromotion Rate: " + promoted + "/" + totalStudents + " (" + 
                          String.format("%.1f", (double)promoted/totalStudents*100) + "%)");
    }

    // Getter methods
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getClassName() { return className; }
    public String[] getSubjects() { return subjects; }
    public double getGpa() { return gpa; }
    public static int getTotalStudents() { return totalStudents; }
    public static String getSchoolName() { return schoolName; }
    public static String[] getGradingScale() { return gradingScale; }
    public static double getPassPercentage() { return passPercentage; }

    // Setter methods
    public static void setSchoolName(String name) { schoolName = name; }
    public static void setPassPercentage(double percentage) { passPercentage = percentage; }
}