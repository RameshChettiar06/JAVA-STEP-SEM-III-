public class StringMethodsDemo {
    public static void main(String[] args) {
        String text = " Welcome to Java Programming World! ";

        System.out.println("=== INSPECTION METHODS ===");
        System.out.println("Original: '" + text + "'");
        System.out.println("Length: " + text.length());
        System.out.println("Character at index 5: " + text.charAt(5));
        System.out.println("First 'a' at index: " + text.indexOf('a'));
        System.out.println("Last 'a' at index: " + text.lastIndexOf('a'));
        System.out.println("Contains 'Java': " + text.contains("Java"));

        System.out.println("\n=== EXTRACTION METHODS ===");
        System.out.println("Substring(0,7): '" + text.substring(0, 7) + "'");
        System.out.println("Substring from 15: '" + text.substring(15) + "'");

        // Split demonstration
        String[] words = text.trim().split(" ");
        System.out.println("Split into " + words.length + " words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println(" " + (i + 1) + ". " + words[i]);
        }

        System.out.println("\n=== MODIFICATION METHODS ===");
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Replace 'Java' with 'Python': " + text.replace("Java", "Python"));
        System.out.println("Replace first 'a' with '@': " + text.replaceFirst("a", "@"));

        System.out.println("\n=== COMPARISON METHODS ===");
        String other = "welcome to programming world!";
        System.out.println("Equals (case-sensitive): " + text.trim().equals(other));
        System.out.println("Equals ignore case: " + text.trim().equalsIgnoreCase(other));
        System.out.println("Starts with ' Welcome': " + text.startsWith(" Welcome"));
        System.out.println("Ends with 'World! ': " + text.endsWith("World! "));
    }
}