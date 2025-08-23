import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Ask user to enter a string
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        // TODO: For each character in the string:
        System.out.println("\n====== ASCII Character Analysis ======\n");

        for (char ch : str.toCharArray()) {
            int ascii = (int) ch;
            // 1. Display the character and its ASCII code
            System.out.println("Character: '" + ch + "' | ASCII: " + ascii);

            // 2. Determine if it's uppercase, lowercase, digit, or special character
            String type = classifyCharacter(ch);
            System.out.println("Type: " + type);

            // 3. If letter, show both upper and lower case versions with ASCII codes
            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.println("Uppercase: " + upper + " (" + (int) upper + ")");
                System.out.println("Lowercase: " + lower + " (" + (int) lower + ")");

                // 4. Calculate the difference between upper and lower case ASCII values
                System.out.println("Difference between cases: " + Math.abs((int) upper - (int) lower));
            }
            System.out.println();
        }

        // TODO: Create ASCII art using character codes
        System.out.println("====== ASCII Table (32-126) ======");
        displayASCIITable(32, 126);

        // TODO: Convert string to ASCII array
        int[] asciiArr = stringToASCII(str);
        System.out.println("\nASCII Array: " + java.util.Arrays.toString(asciiArr));

        // TODO: Convert ASCII array back to string
        String reconstructed = asciiToString(asciiArr);
        System.out.println("Reconstructed String: " + reconstructed);

        // TODO: Implement a simple Caesar cipher using ASCII manipulation
        System.out.print("\nEnter shift value for Caesar Cipher: ");
        int shift = scanner.nextInt();
        String ciphered = caesarCipher(str, shift);
        System.out.println("Ciphered Text: " + ciphered);

        scanner.close();
    }

    // TODO: Method to classify character type
    public static String classifyCharacter(char ch) {
        // Return "Uppercase Letter", "Lowercase Letter", "Digit", or "Special Character"
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    // TODO: Method to convert case using ASCII manipulation
    public static char toggleCase(char ch) {
        // Convert upper to lower and lower to upper using ASCII values
        if (Character.isUpperCase(ch)) {
            return (char) (ch + 32);
        } else if (Character.isLowerCase(ch)) {
            return (char) (ch - 32);
        } else {
            return ch;
        }
    }

    // TODO: Method to implement Caesar cipher
    public static String caesarCipher(String text, int shift) {
        // Shift each letter by 'shift' positions in ASCII
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' + shift + 26) % 26 + 'A');
                result.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch - 'a' + shift + 26) % 26 + 'a');
                result.append(c);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // TODO: Method to create ASCII table for a range
    public static void displayASCIITable(int start, int end) {
        // Display ASCII codes and corresponding characters
        for (int i = start; i <= end; i++) {
            System.out.printf("%3d : %c   ", i, (char) i);
            if ((i - start + 1) % 8 == 0) System.out.println();
        }
        System.out.println();
    }

    // TODO: Method to convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] arr = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = (int) text.charAt(i);
        }
        return arr;
    }

    // TODO: Method to convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder sb = new StringBuilder();
        for (int val : asciiValues) {
            sb.append((char) val);
        }
        return sb.toString();
    }
}

