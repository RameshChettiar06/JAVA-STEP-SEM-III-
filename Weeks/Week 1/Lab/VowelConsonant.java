/*Write a program to find vowels and consonants in a string and display the count of Vowels
and Consonants in the string
Hint =>
a. Create a method to check if the character is a vowel or consonant and return the result.
The logic used here is as follows:

i. Convert the character to lowercase if it is an uppercase letter using the ASCII values
of the characters

ii. Check if the character is a vowel or consonant and return Vowel, Consonant, or Not
a Letter
b. Create a Method to Method to find vowels and consonants in a string using charAt()
method and finally return the count of vowels and consonants in an array
c. Finally, the main function takes user inputs, calls the user-defined methods, and displays
the result. */

import java.util.Scanner;

public class VowelConsonant {
    public static int Length(String text) {
    int count = 0;
    try {
        while (true) { // Keep going until we reach the end
            text.charAt(count); // Will throw exception if out of bounds
            count++;
        }
    }   
        catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Checks and print whether each character is vowel, consonant, or non-letter
    public static void isVowelConsonant(String text) {
        String newText = text.toLowerCase();
        
        for (int i = 0; i < Length(newText); i++) {
            char c = newText.charAt(i);

            if (c >= 'a' && c <= 'z') { // Only letters
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    System.out.println(c + " is a vowel.");
                } 
                
                else {
                    System.out.println(c + " is a consonant.");
                }
            } 
            
            else {
                System.out.println(c + " is not a letter.");
            }
        }
    }

    // Count vowels and consonants
    public static int[] VowelConsonants(String text) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < Length(text); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (c >= 'a' && c <= 'z') { // Only letters
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } 
                
                else {
                    consonants++;
                }
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = input.nextLine();

        isVowelConsonant(sentence);

        int[] counts = VowelConsonants(sentence);
        System.out.println("\nSentence: " + sentence);
        System.out.println("Number of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);

        input.close();
    }
}
