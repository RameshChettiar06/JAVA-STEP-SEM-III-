/*8. Write a program to check if two texts are anagrams and display the result
Hint =>
a. An anagram is a word or phrase formed by rearranging the same letters to form different
words or phrases,
b. Write a method to check if two texts are anagrams. The logic used here is as follows:
i. Check if the lengths of the two texts are equal
ii. Create an array to store the frequency of characters in the strings for the two text
iii. Find the frequency of characters in the two texts using the loop
iv. Compare the frequency of characters in the two texts. If the frequencies are not
equal, return false
c. In the main function take user inputs, call user-defined methods, and displays result. */
import java.util.Scanner;

public class Anagram{
    
    // Custom method to calculate string length without using .length()
    public static int Length(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count); // Throws exception when index is out of bounds
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }
    
    /*b. Write a method to check if two texts are anagrams. The logic used here is as follows:
    i. Check if the lengths of the two texts are equal
    ii. Create an array to store the frequency of characters in the strings for the two text
    iii. Find the frequency of characters in the two texts using the loop
    iv. Compare the frequency of characters in the two texts. If the frequencies are not
    equal, return false */
    public static boolean isAnagram(String text1,String text2){
        // i. Check if the lengths of the two texts are equal
        if (Length(text1) != Length(text2)){
            return false;
        }

        // ii. Create an array to store the frequency of characters in the strings for the two text
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // iii. Find the frequency of characters in the two texts using the loop
        for (int i = 0; i < Length(text1); i++){
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        // iv. Compare the frequency of characters in the two texts
        for (int i = 0; i < 256; i++){
            if (freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }

    // Method to display result
    public static void displayDetails(String text1,String text2){
        if(isAnagram(text1,text2)){
            System.out.println(text1 + " and " + text2 + " are Anagrams to each other");
        }
        else{
            System.out.println(text1 + " and " + text2 + " are not Anagrams to each other");
        }
    }

    // c. In the main function take user inputs, call user-defined methods, and displays result
    public static void main(String args[]){
        Scanner input = new Scanner (System.in);

        System.out.println("Enter text1-->");
        String text1 = input.nextLine();

        System.out.println("Enter text2-->");
        String text2 = input.nextLine();

        displayDetails(text1.trim(),text2.trim());
    }
}
