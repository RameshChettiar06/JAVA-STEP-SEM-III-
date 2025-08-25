public class ASCIIDemo {
    public static void main(String[] args) {
        System.out.println("=== CHARACTER TO ASCII CONVERSION ===");
        // Character to ASCII
        char[] chars = {'A', 'a', '0', '9', ' ', '!', '@'};
        for (char c : chars) {
            System.out.println("'" + c + "' -> ASCII: " + (int)c);
        }

        System.out.println("\n=== ASCII TO CHARACTER CONVERSION ===");
        // ASCII to Character
        int[] asciiValues = {65, 97, 48, 57, 32, 33, 64};
        for (int ascii : asciiValues) {
            System.out.println("ASCII " + ascii + " -> '" + (char)ascii + "'");
        }

        System.out.println("\n=== PRACTICAL ASCII APPLICATIONS ===");
        // Case conversion using ASCII
        String text = "Hello World";
        System.out.println("Original: " + text);

        // Manual uppercase conversion
        String manualUpper = "";
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                manualUpper += (char)(c - 32); // Convert to uppercase
            } else {
                manualUpper += c;
            }
        }
        System.out.println("Manual uppercase: " + manualUpper);

        // Check if character is digit
        char testChar = '5';
        boolean isDigit = (testChar >= '0' && testChar <= '9');
        System.out.println("'" + testChar + "' is digit: " + isDigit);

        // Caesar Cipher example (shift by 3)
        String message = "ABC";
        String encrypted = caesarCipher(message, 10);
        System.out.println("Caesar cipher '" + message + "' -> '" + encrypted + "'");
    }

    public static String caesarCipher(String text, int shift) {
        String result = "";
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result += (char)((c - 'A' + shift) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                result += (char)((c - 'a' + shift) % 26 + 'a');
            } else {
                result += c;
            }
        }
        return result;
    }
}