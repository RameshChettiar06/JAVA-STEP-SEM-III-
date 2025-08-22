import java.util.Scanner;

public class NonRepeating {
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
    
    // Method to find the first non-repeating character
    public static char firstNonRepeatingChar(String text) {
        int[] freq = new int[256]; // Frequency array for ASCII characters

        // First pass: count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Second pass: find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if no non-repeating character found
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Text --> ");
        String text = input.nextLine().trim();

        char result = firstNonRepeatingChar(text);

        if (result != '\0') {
            System.out.println("\nFirst Non-Repeating Character of the String --> " + result);
        } else {
            System.out.println("There are no Non-Repeating Characters in the String.");
        }

        input.close();
    }
}

