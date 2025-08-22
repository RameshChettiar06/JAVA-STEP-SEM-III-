public class StringProcessor {
    // Overloaded process methods

    public static String process(String input) {
        return input.trim().toLowerCase();
    }

    public static String process(String input, boolean uppercase) {
        String processed = input.trim();
        return uppercase ? processed.toUpperCase() : processed.toLowerCase();
    }

    public static String process(String input, String prefix, String suffix) {
        return prefix + input.trim() + suffix;
    }

    public static void main(String[] args) {
        System.out.println(process("   Hello World   "));
        System.out.println(process("   Hello World   ", true));
        System.out.println(process("   Hello World   ", "[", "]"));
    }
}
