/*Write a program to take user input for the age of all 10 students in a class and check
whether the student can vote depending on his/her age is greater or equal to 18.
Hint =>
a. Create a method to define the random 2-digit age of several students provided as
method parameters and return a 1D array of ages of n students
b. Create a method that takes an array of age as a parameter and returns a 2D String array
of age and a boolean true or false to indicate can and cannot vote. Inside the method
firstly validate the age for a negative number, if a negative cannot vote. For valid age
check for age is 18 or above to set true to indicate can vote.
c. Create a method to display the 2D array in a tabular format.
d. Finally, the main function takes user inputs, calls the user-defined methods, and displays
the result. */

import java.util.Scanner;

public class StudentVoter {
    static Scanner input = new Scanner(System.in);

    // Function 1: Take ages
    public static int[] age(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter age (10-100) --> ");
            int age = input.nextInt();
            if (age < 10 || age > 100) {
                System.out.println("Invalid age! Enter again.");
                i--; // repeat for same index
            } else {
                array[i] = age;
            }
        }
        return array;
    }

    // Function 2: Check voting eligibility
    public static boolean[] Array(int[] ages) {
        boolean[] canVote = new boolean[ages.length];
        for (int i = 0; i < ages.length; i++) {
            canVote[i] = (ages[i] >= 18); // true if >= 18
        }
        return canVote;
    }

    // Function 3: Display details
    public static void DisplayArray(int[] ages, boolean[] votes) {
        System.out.println("\n---------------DETAILS---------------");
        System.out.println("Person\t\t1Age\t\tCanVote?");
        for (int i = 0; i < ages.length; i++) {
            System.out.println((i + 1) + "\t\t" + ages[i] + "\t\t" + votes[i]);
        }
    }

    // Main
    public static void main(String args[]) {
        System.out.print("Enter Number of People --> ");
        int n = input.nextInt();

        int[] PersonAges = age(n);
        boolean[] voteChecker = Array(PersonAges);
        DisplayArray(PersonAges, voteChecker);

        input.close();
    }
}
