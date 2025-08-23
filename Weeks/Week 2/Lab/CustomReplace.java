/*Problem 1: Write a program to find and replace all occurrences of a
substring in a text without using the replace() method
Hint =>
a. Take user input using the Scanner nextLine() method for the main text and the substring
to find and replace
b. Create a method to find all occurrences of the substring using indexOf() method in a loop
and store the starting positions in an array
c. Create a method to replace the substring manually by:
● i. Building a new string character by character using charAt() method
● ii. Skip the characters of the original substring and insert the replacement substring
d. Create a method to compare the result with the built-in replace() method and return a
boolean
e. The main function calls all user-defined methods and displays both results along with the
comparison */

import java.util.ArrayList;
import java.util.Scanner;

public class CustomReplace {

    /*b. Create a method to find all occurrences of the substring using indexOf() method in a loop
    and store the starting positions in an array */
    public static ArrayList<Integer> findAllOccurrences(String text, String find) {
        ArrayList<Integer> positions = new ArrayList<>();
        int index = text.indexOf(find);

        while (index != -1) {
            positions.add(index);
            index = text.indexOf(find, index + find.length()); // FIX: move by full word, not +1
        }
        return positions;
    }

    /*c. Create a method to replace the substring manually by:
    ● i. Building a new string character by character using charAt() method
    ● ii. Skip the characters of the original substring and insert the replacement substring */
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            if (i <= text.length() - find.length() &&
                text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    /*d. Create a method to compare the result with the built-in replace() method and return a
    boolean */
    public static boolean compareResults(String manual, String builtin) {
        return manual.equals(builtin);
    }

    /*e. The main function calls all user-defined methods and displays both results along with the
    comparison */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the main text:");
        String text = input.nextLine();

        System.out.println("Enter the substring to find:");
        String find = input.nextLine();

        System.out.println("Enter the substring to replace with:");
        String replace = input.nextLine();

        ArrayList<Integer> positions = findAllOccurrences(text, find);
        System.out.println("Found at positions: " + positions);

        String manualResult = manualReplace(text, find, replace);
        String builtInResult = text.replace(find, replace);

        boolean isSame = compareResults(manualResult, builtInResult);

        System.out.println("\n====== RESULTS ======");
        System.out.println("Original text:   " + text);
        System.out.println("Manual result:   " + manualResult);
        System.out.println("Built-in result: " + builtInResult);
        System.out.println("Both are same?   " + isSame);

        input.close();
    }
}
