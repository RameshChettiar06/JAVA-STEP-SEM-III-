/*Create a Student class that demonstrates proper class structure and object instantiation. */
public class Student {
        // TODO: Define private instance variables:
        // - studentId (String)
        // - name (String)
        // - grade (double)
        // - course (String)
        private String studentId, name, course;
        private double grade;
        
        // TODO: Create a default constructor (no parameters)
        public Student() {
            this.studentId = "";
            this.name = "";
            this.course = "";
            this.grade = 0.0;
        }
        
        // TODO: Create a parameterized constructor that accepts all attributes
        public Student(String studentId, String name, double grade, String course) {
            this.studentId = studentId;
            this.name = name;
            this.grade = grade;
            this.course = course;
        }
        
        // TODO: Create getter and setter methods for all attributes
        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        
        // TODO: Create a method calculateLetterGrade() that returns:
        // A (90-100), B (80-89), C (70-79), D (60-69), F (below 60)
        public String calculateLetterGrade() {
            if (grade >= 90 && grade <= 100) {
                return "A";
            } else if (grade >= 80 && grade < 90) {
                return "B";
            } else if (grade >= 70 && grade < 80) {
                return "C";
            } else if (grade >= 60 && grade < 70) {
                return "D";
            } else {
                return "F";
            }
        }

        // TODO: Create a method displayStudent() that shows all information
        public void displayStudent() {
            System.out.println("Student ID: " + studentId);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("Course: " + course);
            System.out.println("Letter Grade: " + calculateLetterGrade());
        }

        public static void main(String[] args) {
            // TODO: Create one student using default constructor, then set values
            Student student1 = new Student();
            student1.setStudentId("RA2411030010263");
            student1.setName("RAMESH");
            student1.setGrade(93.5);
            student1.setCourse("Cryptography");

            // TODO: Create another student using parameterized constructor
            Student student2 = new Student("RA2411030010264", "RAVI", 92.0, "Digital Forensics");

            // TODO: Demonstrate all getter/setter methods
            System.out.println("Student 1 ID: " + student1.getStudentId());
            System.out.println("Student 1 Name: " + student1.getName());
            System.out.println("Student 1 Grade: " + student1.getGrade());
            System.out.println("Student 1 Course: " + student1.getCourse());

            student1.setGrade(90.0);
            System.out.println("Updated Student 1 Grade: " + student1.getGrade());

            // TODO: Show both students' information and letter grades
            student1.displayStudent();
            student2.displayStudent();
        }
}