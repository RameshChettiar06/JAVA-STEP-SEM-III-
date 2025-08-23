import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Ask user to enter a sentence with mixed formatting
        System.out.println("Enter a sentence (with digits, punctuation, and spaces):");
        String sentence = scanner.nextLine();

        // TODO: Process the input using the following methods:
        System.out.println("\n====== String Manipulation Demo ======\n");

        // 1. trim() - Remove extra spaces
        String trimmed = sentence.trim();
        System.out.println("1. After trim(): \"" + trimmed + "\"");

        // 2. replace() - Replace all spaces with underscores
        String replaced = trimmed.replace(" ", "_");
        System.out.println("2. After replace spaces: " + replaced);

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("3. After removing digits: " + noDigits);

        // 4. split() - Split sentence into words array
        String[] words = trimmed.split("\\s+");
        System.out.println("4. Words array: " + Arrays.toString(words));

        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("5. Rejoined with | : " + joined);

        // TODO: Create additional processing methods:
        // - Remove all punctuation
        String noPunctuation = removePunctuation(trimmed);
        System.out.println("\nExtra 1. After removing punctuation: " + noPunctuation);

        // - Capitalize first letter of each word
        String capitalized = capitalizeWords(noPunctuation);
        System.out.println("Extra 2. Capitalized words: " + capitalized);

        // - Reverse the order of words
        String reversedOrder = reverseWordOrder(noPunctuation);
        System.out.println("Extra 3. Reversed word order: " + reversedOrder);

        // - Count word frequency
        System.out.println("Extra 4. Word frequency:");
        countWordFrequency(noPunctuation);

        scanner.close();
    }

    // TODO: Method to remove punctuation
    public static String removePunctuation(String text) {
        return text.replaceAll("[\\p{Punct}]", "");
    }

    // TODO: Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            if (w.length() > 0) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                  .append(w.substring(1).toLowerCase())
                  .append(" ");
            }
        }
        return sb.toString().trim();
    }

    // TODO: Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // TODO: Method to count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<String, Integer> frequencyMap = new LinkedHashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

