/*Problem 3: Write a program to analyze and compare the performance of
String concatenation vs StringBuilder vs StringBuffer for building large
strings
Hint =>
a. Take user input for the number of iterations (e.g., 1000, 10000, 100000)
b. Create a method to perform String concatenation in a loop:
   ● i. Use System.currentTimeMillis() to measure start and end time
   ● ii. Concatenate a sample string multiple times using the + operator
   ● iii. Return the time taken and final string length
c. Create a method to perform StringBuilder operations:
   ● i. Use StringBuilder.append() method in a loop
   ● ii. Measure the time taken and return results
d. Create a method to perform StringBuffer operations:
   ● i. Use StringBuffer.append() method in a loop
   ● ii. Measure the time taken and return results
e. Create a method to display performance comparison in a tabular format */

import java.util.Scanner;

public class CustomStringTester {

    /*b. Perform String concatenation in a loop */
    public static long stringConcatTest(int n) {
        String result = "";
        long start = System.currentTimeMillis();
        for(int i=0; i<n; i++) {
            result += "x";
        }
        long end = System.currentTimeMillis();
        System.out.println("Final length using String: " + result.length());
        return (end-start);
    }

    /*c. Perform StringBuilder operations */
    public static long stringBuilderTest(int n) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for(int i=0; i<n; i++) {
            sb.append("x");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final length using StringBuilder: " + sb.length());
        return (end-start);
    }

    /*d. Perform StringBuffer operations */
    public static long stringBufferTest(int n) {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for(int i=0; i<n; i++) {
            sb.append("x");
        }
        long end = System.currentTimeMillis();
        System.out.println("Final length using StringBuffer: " + sb.length());
        return (end-start);
    }

    /*e. Display performance comparison */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        long timeString = stringConcatTest(n);
        long timeBuilder = stringBuilderTest(n);
        long timeBuffer = stringBufferTest(n);

        System.out.println("\n====== PERFORMANCE COMPARISON ======");
        System.out.printf("%-20s %-20s\n", "Method", "Time Taken (ms)");
        System.out.println("------------------------------------------");
        System.out.printf("%-20s %-20d\n", "String (+)", timeString);
        System.out.printf("%-20s %-20d\n", "StringBuilder", timeBuilder);
        System.out.printf("%-20s %-20d\n", "StringBuffer", timeBuffer);

        sc.close();
    }
}
