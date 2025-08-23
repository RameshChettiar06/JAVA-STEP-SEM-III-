/*Problem 1: Write a program to implement a simple spell checker that finds
and suggests corrections for misspelled words using string distance
calculation
Hint =>
a. Take user input for a sentence and a dictionary of correct words (stored in an array)
b. Create a method to split the sentence into words without using split():
● i. Use charAt() to identify word boundaries (spaces, punctuation)
● ii. Extract each word using substring() method
● iii. Store words in an array
c. Create a method to calculate string distance between two words:
● i. Count character differences between words of same length
● ii. For different lengths, calculate insertion/deletion distance
● iii. Return the distance as an integer
d. Create a method to find the closest matching word from dictionary:
● i. Compare input word with each dictionary word
● ii. Find the word with minimum distance
● iii. Return the suggestion if distance is within acceptable range (≤ 2)
e. Create a method to display spell check results in tabular format:
● i. Show original word, suggested correction, distance score
● ii. Mark words as "Correct" or "Misspelled"
f. The main function processes the sentence and displays comprehensive spell check report */

import java.util.Scanner;

public class CustomSpellChecker {

    /* b. Extract words without using split() */
    public static String[] extractWords(String sentence) {
        int n = sentence.length();
        StringBuilder word = new StringBuilder();
        String[] temp = new String[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = sentence.charAt(i);
            if (Character.isLetter(ch)) {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    temp[count++] = word.toString();
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            temp[count++] = word.toString();
        }

        String[] words = new String[count];
        System.arraycopy(temp, 0, words, 0, count);
        return words;
    }

    /* c. String distance calculation */
    public static int stringDistance(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int minLen = Math.min(lenA, lenB);
        int diff = Math.abs(lenA - lenB);

        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff;
    }

    /* d. Find closest dictionary word */
    public static String suggestWord(String word, String[] dictionary) {
        String suggestion = word;
        int minDist = Integer.MAX_VALUE;

        for (String dictWord : dictionary) {
            int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
            if (dist < minDist) {
                minDist = dist;
                suggestion = dictWord;
            }
        }

        if (minDist <= 2 && !suggestion.equalsIgnoreCase(word)) {
            return suggestion;
        } else {
            return "Correct";
        }
    }

    /* e. Display spell check results */
    public static void displayResults(String[] words, String[] dictionary) {
        System.out.printf("%-15s %-20s %-10s %-15s%n", "Word", "Suggestion", "Distance", "Status");
        System.out.println("-------------------------------------------------------------");

        for (String word : words) {
            String bestMatch = word;
            String status = "Correct";
            int minDist = Integer.MAX_VALUE;

            for (String dictWord : dictionary) {
                int dist = stringDistance(word.toLowerCase(), dictWord.toLowerCase());
                if (dist < minDist) {
                    minDist = dist;
                    bestMatch = dictWord;
                }
            }

            String suggestion;
            if (minDist == 0) {
                suggestion = "-";
                status = "Correct";
            } else if (minDist <= 2) {
                suggestion = bestMatch;
                status = "Misspelled";
            } else {
                suggestion = "No close match";
                status = "Misspelled";
            }

            System.out.printf("%-15s %-20s %-10d %-15s%n", word, suggestion, minDist, status);
        }
    }

    /* f. Main method */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of dictionary words: ");
        int n = input.nextInt();
        input.nextLine();
        String[] dictionary = new String[n];
        System.out.println("Enter dictionary words:");
        for (int i = 0; i < n; i++) {
            dictionary[i] = input.nextLine().trim();
        }

        System.out.println("Enter a sentence to check:");
        String sentence = input.nextLine();
        String[] words = extractWords(sentence);

        displayResults(words, dictionary);
        input.close();
    }
}
