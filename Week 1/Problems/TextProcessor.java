import java.util.Scanner;
import java.util.Arrays;

public class TextProcessor{
    // TODO: Method to clean and validate input
    public static String cleanInput(String input) {
        // Remove extra spaces, convert to proper case
        // Return cleaned string
        return input.trim();
    }

    // TODO: Method to analyze text
    public static void analyzeText(String text) {
        // Count: words, sentences, characters
        int w = 0,s = 0,c = 0,count = 0;
        for (int i = 0 ; i < text.length(); i++){
            if(text.charAt(i) == ' '){
                count++;
            }
            if(text.charAt(i) == '.'){
                s++;
            }
            c++;
        }
        w = count + 1;
        
        // Find: longest word, most common character
        String words[] = text.split(" ");
        String longestWord = words[0];
        for(int i = 1 ; i < words.length; i++){
            if(longestWord.length() < words[i].length()){
                longestWord = words[i];
            }
        }
        
        int maxCount = 0;
        char mostCommon = text.charAt(0);
        for (int i = 0; i < text.length(); i++) {
            int charCount = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    charCount++;
                }
            }
            if (charCount > maxCount && text.charAt(i) != ' ') {
                maxCount = charCount;
                mostCommon = text.charAt(i);
            }
        }

        System.out.println("-------------------STATISTICS-------------------");
        System.out.println("String-->"+text);
        System.out.println("Number of words in String-->"+w);
        System.out.println("Number of sentences in the String-->"+s);
        System.out.println("Number of characters in the String-->"+c);
        System.out.println("Longest Word in the String-->"+longestWord);
        System.out.println("Most common character in the String-->"+mostCommon);
    }

    // TODO: Method to create word array and sort alphabetically
    public static String[] getWordsSorted(String text) {
        // Split text into words, remove punctuation, sort
        // Return sorted array
        String words[] = text.split(" ");
        for (int i = 0 ; i < words.length ; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < words[i].length(); j++){
                if (Character.isLetterOrDigit(words[i].charAt(j))){
                    sb.append(words[i].charAt(j));
                }
            }
            words[i] = sb.toString();
        }

        Arrays.sort(words);
        return words;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Create a text processor that:
        // 1. Asks user for a paragraph of text
        // 2. Cleans and validates the input
        // 3. Analyzes the text (word count, character count, etc.)
        // 4. Shows the words in alphabetical order
        // 5. Allows user to search for specific words
        System.out.println("=== TEXT PROCESSOR ===");

        System.out.println("Enter a Paragraph of Text:");
        String text = scanner.nextLine();

        text = cleanInput(text);

        analyzeText(text);

        String sortedText[] = getWordsSorted(text);
        System.out.println("\nWords in alphabetical order:");
        for (String w : sortedText) {
            System.out.println(w);
        }

        System.out.println("\nEnter Word to be searched-->");
        String Element = scanner.nextLine();
        int r = 0;
        for (String word: sortedText){
            if (word.equals(Element)){
                System.out.println(Element + " found!");
                r++;
                break;
            }
        }
        if (r == 0){
            System.out.println(Element + " not found!");
        }

        scanner.close();
    }
}
