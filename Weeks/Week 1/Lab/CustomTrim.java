/*7. Write a program to trim the leading and trailing spaces from a string using the charAt()
method
Hint =>
a. Create a method to trim the leading and trailing spaces from a string using the charAt()
method. Inside the method run a couple of loops to trim leading and trailing spaces and
determine the starting and ending points with no spaces. Return the start point and end
point in an array
b. Write a method to create a substring from a string using the charAt() method with the
string, start, and end index as the parameters
c. Write a method to compare two strings using the charAt() method and return a boolean
result
d. The main function calls the user-defined trim and substring methods to get the text after
trimming the leading and trailing spaces. Post that use the String built-in method trim()
to trim spaces and compare the two strings. And finally display the result */

import java.util.Scanner;

public class CustomTrim{
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

    public static String trimFunction(String text){
        StringBuilder sb = new StringBuilder();
        int count1 = 0,count2 = 0;
        int i = 0;
        while(i < Length(text) ){
            if (text.charAt(i) == ' '){
                count1 ++;
            }
            else{
                break;
            }
            i++;
        }
       
        i = Length(text) - 1;
        while(i >= 0){
            if (text.charAt(i) == ' '){
                count2 ++;
            }
            else{
                break;
            }
            i--;
        }

        for (int j = count1; j < Length(text) - count2 ; j++){
            sb.append(text.charAt(j));
        }

        String returnString = sb.toString();
        return returnString;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter sentence-->");
        String sentence = input.nextLine();

        System.out.println("After Trim-->"+trimFunction(sentence));

        input.close();
    }
}