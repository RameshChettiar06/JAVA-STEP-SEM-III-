import java.util.Scanner;
import java.util.Arrays;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ASCII CHARACTER ANALYZER ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n====== CHARACTER ANALYSIS ======\n");
        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            System.out.println("Character: '" + ch + "' | ASCII: " + ascii);

            // Character classification
            String type = classifyCharacter(ch);
            System.out.println("Type: " + type);

            // Case conversion and difference
            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Uppercase: " + upper + " (" + (int) upper + ")");
                System.out.println("Lowercase: " + lower + " (" + (int) lower + ")");
                System.out.println("Difference between cases: " + Math.abs(upper - lower));

                // Optional: Toggle case using ASCII math
                char toggled = toggleCase(ch);
                System.out.println("Toggled Case: " + toggled + " (" + (int) toggled + ")");
            }

            System.out.println();
        }

        // ASCII Table Display
        System.out.println("====== ASCII TABLE (32–126) ======");
        displayASCIITable(32, 126);

        // String to ASCII array
        int[] asciiArray = stringToASCII(input);
        System.out.println("\nASCII Array: " + Arrays.toString(asciiArray));

        // ASCII array back to string
        String reconstructed = asciiToString(asciiArray);
        System.out.println("Reconstructed String: " + reconstructed);

        scanner.close();
    }

    // Classify character type
    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    // Toggle case using ASCII math
    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) return (char) (ch + 32);
        else if (Character.isLowerCase(ch)) return (char) (ch - 32);
        else return ch;
    }

    // Display ASCII table in rows of 8
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%3d : %c   ", i, (char) i);
            if ((i - start + 1) % 8 == 0) System.out.println();
        }
        System.out.println();
    }

    // Convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    // Convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}