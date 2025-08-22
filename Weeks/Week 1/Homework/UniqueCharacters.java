/* 
2. Find unique characters in a string using the charAt() method and display the result
Hint =>
a. Create a Method to find the length of the text without using the String method length()
b. Create a method to Find unique characters in a string using the charAt() method and
   return them as a 1D array. The logic used here is as follows:
   i. Create an array to store the unique characters in the text. The size is the length of the text
   ii. Loops to Find the unique characters in the text. Find the unique characters in the text
       using a nested loop. An outer loop iterates through each character and an inner loop
       checks if the character is unique by comparing it with the previous characters. 
       If the character is unique, it is stored in the result array
   iii. Create a new array to store the unique characters 
*/

import java.util.Scanner;

public class UniqueCharacters {
        // a. Create a Method to find the length of the text without using the String method length()
    public static int Length(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // Throws exception when index is out of bounds
                count++;            // Increase counter until exception occurs
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached, return count
        }
        return count;
    }

    // b. Create a method to find unique characters in the string
    public static char[] uniqueChar(String text) {
        // i. Create a temporary array to store unique characters
        char[] unique = new char[Length(text)];
        int size = 0; // Counter for number of unique characters found

        // ii. Outer loop → go through each character in the string
        for (int i = 0; i < Length(text); i++) {
            char ch = text.charAt(i);
            boolean found = false;

            // Inner loop → check if the character already exists in unique[]
            for (int j = 0; j < size; j++) {
                if (ch == unique[j]) {
                    found = true; // Character already exists
                    break;
                }
            }

            // If not found, add the character to the unique[] array
            if (!found) {
                unique[size] = ch;
                size++;
            }
        }

        // iii. Create a new array result[] with only the exact number of unique characters
        char[] result = new char[size];
        for (int i = 0; i < size; i++) {
            result[i] = unique[i];
        }
        return result; // return the unique characters
    }

    // Method to display results
    public static void displayDetails(String text, char[] result) {
        System.out.println("Entered text--->" + text);
        System.out.println("Unique Characters in the above text-->");
        
        // Printing each unique character
        for (int i = 0; i < Length(new String(result)); i++) {
            System.out.println("Character " + (i + 1) + " --> " + result[i]);
        }

        // Print total stats
        System.out.println("Out of " + Length(text) + " ,there is/are only " 
                           + Length(new String(result)) + " Unique Characters.");
    }

    // Main method
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.println("Enter text-->");
        String text = input.nextLine();

        // Find unique characters in the input
        char uniqueCharacters[] = uniqueChar(text.trim());

        // Display results
        displayDetails(text, uniqueCharacters);
    }
}
