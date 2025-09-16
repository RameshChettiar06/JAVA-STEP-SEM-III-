class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    // Static variables for subject management
    private static int totalSubjects = 0;
    private static Subject[] allSubjects = new Subject[50]; // Max 50 subjects

    // Constructor
    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
        
        // Add to static array
        if (totalSubjects < allSubjects.length) {
            allSubjects[totalSubjects] = this;
            totalSubjects++;
        }
    }

    // Getter methods
    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }

    // Setter methods
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setCredits(int credits) { this.credits = credits; }

    // Static method to find subject by code
    public static Subject findSubjectByCode(String code) {
        for (int i = 0; i < totalSubjects; i++) {
            if (allSubjects[i] != null && allSubjects[i].getSubjectCode().equals(code)) {
                return allSubjects[i];
            }
        }
        return null;
    }

    // Static method to find subject by name
    public static Subject findSubjectByName(String name) {
        for (int i = 0; i < totalSubjects; i++) {
            if (allSubjects[i] != null && allSubjects[i].getSubjectName().equalsIgnoreCase(name)) {
                return allSubjects[i];
            }
        }
        return null;
    }

    // Static method to get all subjects
    public static Subject[] getAllSubjects() {
        Subject[] result = new Subject[totalSubjects];
        for (int i = 0; i < totalSubjects; i++) {
            result[i] = allSubjects[i];
        }
        return result;
    }

    // Static method to display all subjects
    public static void displayAllSubjects() {
        System.out.println("\n=== ALL SUBJECTS ===");
        if (totalSubjects == 0) {
            System.out.println("No subjects registered.");
            return;
        }

        System.out.println("Code\tName\t\tCredits\tInstructor");
        System.out.println("----\t----\t\t-------\t----------");
        for (int i = 0; i < totalSubjects; i++) {
            if (allSubjects[i] != null) {
                System.out.println(allSubjects[i].subjectCode + "\t" + 
                                 allSubjects[i].subjectName + "\t\t" +
                                 allSubjects[i].credits + "\t" +
                                 allSubjects[i].instructor);
            }
        }
        System.out.println("Total Subjects: " + totalSubjects);
    }

    // Static method to get subjects by instructor
    public static Subject[] getSubjectsByInstructor(String instructorName) {
        Subject[] result = new Subject[totalSubjects];
        int count = 0;

        for (int i = 0; i < totalSubjects; i++) {
            if (allSubjects[i] != null && 
                allSubjects[i].getInstructor().equalsIgnoreCase(instructorName)) {
                result[count++] = allSubjects[i];
            }
        }

        // Resize array to actual count
        Subject[] finalResult = new Subject[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    // Display subject information
    public void displaySubjectInfo() {
        System.out.println("Subject Code: " + subjectCode);
        System.out.println("Subject Name: " + subjectName);
        System.out.println("Credits: " + credits);
        System.out.println("Instructor: " + instructor);
    }

    // Static getter methods
    public static int getTotalSubjects() { return totalSubjects; }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", credits=" + credits +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}