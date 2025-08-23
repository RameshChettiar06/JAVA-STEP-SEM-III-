/*Problem 2: Write a program to convert text between different cases
(uppercase, lowercase, title case) using ASCII values without using built-in
case conversion methods
Hint =>
a. Take user input using the Scanner nextLine() method
b. Create a method to convert a character to uppercase using ASCII values:
● i. Check if the character is a lowercase letter (ASCII 97-122)
● ii. Convert by subtracting 32 from the ASCII value
c. Create a method to convert a character to lowercase using ASCII values:
● i. Check if the character is an uppercase letter (ASCII 65-90)
● ii. Convert by adding 32 to the ASCII value
d. Create a method for title case conversion:
● i. Convert the first character of each word to uppercase
● ii. Convert all other characters to lowercase
e. Create a method to compare results with built-in methods (toUpperCase(),
toLowerCase())
f. The main function calls all methods and displays the results in a tabular format */

import java.util.Scanner;

public class CustomASCIICaseConvertor {

    /*b. Convert char to uppercase using ASCII values */
    public static char toUpperChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }

    /*c. Convert char to lowercase using ASCII values */
    public static char toLowerChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

    /*d. Convert whole string to uppercase manually */
    public static String toUpperCaseManual(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(toUpperChar(c));
        }
        return sb.toString();
    }

    /* Convert whole string to lowercase manually */
    public static String toLowerCaseManual(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(toLowerChar(c));
        }
        return sb.toString();
    }

    /* Title case conversion manually */
    public static String toTitleCaseManual(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;

        for (char c : text.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpperChar(c));
                    newWord = false;
                } else {
                    sb.append(toLowerChar(c));
                }
            }
        }
        return sb.toString();
    }

    /* Built-in title case for comparison */
    public static String toTitleCaseBuiltIn(String text) {
        String[] words = text.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
            if (i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    /*a. Main function */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a text:");
        String text = input.nextLine();

        String upperManual = toUpperCaseManual(text);
        String lowerManual = toLowerCaseManual(text);
        String titleManual = toTitleCaseManual(text);

        String upperBuiltIn = text.toUpperCase();
        String lowerBuiltIn = text.toLowerCase();
        String titleBuiltIn = toTitleCaseBuiltIn(text);

        System.out.println("\n====== CASE CONVERSION RESULTS ======");
        System.out.printf("%-20s %-40s %-40s\n", "Conversion", "Manual Result", "Built-in Result");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-40s %-40s\n", "UPPERCASE", upperManual, upperBuiltIn);
        System.out.printf("%-20s %-40s %-40s\n", "lowercase", lowerManual, lowerBuiltIn);
        System.out.printf("%-20s %-40s %-40s\n", "Title Case", titleManual, titleBuiltIn);

        input.close();
    }
}
