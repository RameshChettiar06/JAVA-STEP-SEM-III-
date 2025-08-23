public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        // 1. Display original string length including spaces
        System.out.println("1. Original length (with spaces): " + sampleText.length());

        // 2. Remove leading and trailing spaces, show new length
        String trimmedText = sampleText.trim();
        System.out.println("2. After trim: \"" + trimmedText + "\" (length = " + trimmedText.length() + ")");

        // 3. Find and display the character at index 5
        System.out.println("3. Character at index 5: " + sampleText.charAt(5));

        // 4. Extract substring "Programming" from the text
        String substring = sampleText.substring(6, 17);
        System.out.println("4. Substring (Programming): " + substring);

        // 5. Find the index of the word "Fun"
        System.out.println("5. Index of 'Fun': " + sampleText.indexOf("Fun"));

        // 6. Check if the string contains "Java" (case-sensitive)
        System.out.println("6. Contains 'Java': " + sampleText.contains("Java"));

        // 7. Check if the string starts with "Java" (after trimming)
        System.out.println("7. Starts with 'Java' after trimming: " + trimmedText.startsWith("Java"));

        // 8. Check if the string ends with an exclamation mark
        System.out.println("8. Ends with '!': " + sampleText.endsWith("!"));

        // 9. Convert the entire string to uppercase
        System.out.println("9. Uppercase: " + sampleText.toUpperCase());

        // 10. Convert the entire string to lowercase
        System.out.println("10. Lowercase: " + sampleText.toLowerCase());

        // TODO: Create a method that counts vowels using charAt()
        int vowelCount = countVowels(sampleText);
        System.out.println("\nExtra 1: Vowel count = " + vowelCount);

        // TODO: Create a method that finds all occurrences of a character
        System.out.print("Extra 2: Occurrences of 'a' at positions: ");
        findAllOccurrences(sampleText, 'a');
    }

    // TODO: Method to count vowels in a string
    public static int countVowels(String text) {
        int count = 0;
        String vowels = "AEIOUaeiou";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // TODO: Method to find all positions of a character
    public static void findAllOccurrences(String text, char target) {
        boolean found = false;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
}

