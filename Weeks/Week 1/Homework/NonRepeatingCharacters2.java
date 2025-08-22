import java.util.Scanner;

public class NonRepeatingCharacters2 {

    /*a. Create a method to find the frequency of characters in a string using the charAt() method
    and return the characters and their frequencies in a 2D array. The logic used here is as
    follows:
    i. Create an array to store the frequency of characters in the text. ASCII values of
    characters are used as indexes in the array to store the frequency of each character.
    There are 256 ASCII characters
    ii. Loop through the text to find the frequency of characters in the text
    iii. Create an array to store the characters and their frequencies
    iv. Loop through the characters in the text and store the characters and their
    frequencies */
    public static int[][] CharacterFrequencies(String text) {
        int[] freq = new int[256]; // i. Array to store frequency of ASCII characters

        // ii. Loop through the text to count frequency using ASCII values as indexes
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            freq[c]++;
        }

        // Counting how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // iii. Create a 2D array to store characters and their frequencies
        int[][] result = new int[uniqueCount][2];
        int index = 0;

        // iv. Loop through characters and store ASCII value and their frequencies
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;       
                result[index][1] = freq[i]; 
                index++;
            }
        }

        return result;
    }

    /*b. Main(). */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        int[][] frequencies = CharacterFrequencies(text);

        // Display Details
        System.out.println("Character Frequencies:");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println((char)frequencies[i][0] + " -> " + frequencies[i][1]);
        }

        input.close();
    }
}
