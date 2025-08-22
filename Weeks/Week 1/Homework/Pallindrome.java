import java.util.Scanner;

public class Pallindrome {

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

    /* Logic 1: Write a method to compare the characters from the start and end of the string
    to determine whether the text is palindrome. The logic used here is as follows:
    i. Set the start and end indexes of the text
    ii. Loop through the text and compare the characters from the start and the end of the
    string. If the characters are not equal, return false */
    public static boolean Logic1(String text) {
        int start = 0;
        int end = Length(text) - 1;

        while (start <= end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /* c. Logic 2: Write a recursive method to compare the characters from the start and end of
    the text passed as parameters using recursion. The logic used here is as follows:
    i. First, check if the start index is greater than or equal to the end index, then return
    true.
    ii. If the characters at the start and end indexes are not equal, return false.
    iii. Otherwise, call the method recursively with the start index incremented by 1 and the
    end index decremented by 1 */
    public static boolean Logic2(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return Logic2(text, start + 1, end - 1);
    }

    /* d. Logic 3: Write a Method to compare the characters from the start and end of the text
    using character arrays. The logic used here is as follows:
    i. Firstly Write a Method to reverse a string using the charAt() method and return the
    reversal array.
    ii. Create a character array using the String method toCharArray() and also create a
    reverse array. Compare the characters in the original and reverse arrays to do a
    Palindrome check */
    public static char[] arrayReversal(String text) {
        int end = Length(text) - 1;
        char[] characters = new char[Length(text)];
        int index = 0;

        while (end >= 0) {
            characters[index] = text.charAt(end);
            end--;
            index++;
        }
        return characters;
    }

    public static boolean Logic3(String text) {
        char[] reversedArray = arrayReversal(text);
        char[] array = text.toCharArray();

        for (int i = 0; i < Length(text); i++) {
            if (reversedArray[i] != array[i]) {
                return false;
            }
        }
        return true;
    }

    
    public static void displayDetails(String text) {
        System.out.println("\n-----------------------DETAILS-----------------------");
        System.out.println(text + " is a Palindrome.");
    }

   //Main()
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Text---------->");
        String text = input.nextLine();

        System.out.println("Which Logic do you want to check if the entered Text is Palindrome or not:");
        System.out.println("Logic 1(1), Logic 2(2) and Logic 3(3)");
        int logic = input.nextInt();

        switch (logic) {
            case 1:
                if (Logic1(text.trim())) {
                    displayDetails(text.trim());
                } else {
                    System.out.println(text + " is not a Palindrome.");
                }
                break;

            case 2:
                int start = 0;
                int end = Length(text.trim()) - 1;
                if (Logic2(text.trim(), start, end)) {
                    displayDetails(text.trim());
                } else {
                    System.out.println(text + " is not a Palindrome.");
                }
                break;

            case 3:
                if (Logic3(text.trim())) {
                    displayDetails(text.trim());
                } else {
                    System.out.println(text + " is not a Palindrome.");
                }
                break;

            default:
                System.out.println("No Such Logic! Please Enter the Correct Choice!!");
        }

        input.close();
    }
}
