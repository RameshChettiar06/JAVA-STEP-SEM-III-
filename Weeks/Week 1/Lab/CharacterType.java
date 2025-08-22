/*Write a program to find vowels and consonants in a string and display the character type -
Vowel, Consonant, or Not a Letter
Hint =>
a. Create a method to check if the character is a vowel or consonant and return the result.
The logic used here is as follows:
i. Convert the character to lowercase if it is an uppercase letter using the ASCII values
of the characters
ii. Check if the character is a vowel or consonant and return Vowel, Consonant, or Not
a Letter
b. Create a Method to find vowels and consonants in a string using charAt() method and
return the character and vowel or consonant in a 2D array
c. Create a Method to display the 2D Array of Strings in a Tabular Format
d. Finally, the main function takes user inputs, calls the user-defined methods, and displays
the result.  */

import java.util.Scanner;

public class CharacterType {

    // Custom method to calculate string length without using .length()
    public static int Length(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // Throws exception when index is out of bounds
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Checks and prints whether each character is a vowel, consonant, or non-letter
    public static void isVowelConsonant(String text) {
        String newText = text.toLowerCase();

        for (int i = 0; i < Length(newText); i++) {
            char c = newText.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    System.out.println(c + " is a vowel.");
                } else {
                    System.out.println(c + " is a consonant.");
                }
            } else {
                System.out.println(c + " is not a letter.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = input.nextLine();

        isVowelConsonant(sentence);

        input.close();
    }
}

