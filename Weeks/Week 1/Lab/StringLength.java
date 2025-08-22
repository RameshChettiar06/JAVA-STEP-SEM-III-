//Write a program to find and return the length of a string without using the length() method
import java.util.Scanner;

public class StringLength{
    public static int Length(String text) {
        int count = 0;
        int i = 0;
        try {
            while (i >= 0) { 
                if (Character.isLetterOrDigit(text.charAt(i))) {
                    count++;
                }
                i++;
            }
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
        return count+1;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = input.nextLine();

       
        //Function calling
        int length = Length(str);
        System.out.println("User Defined Function-->"+length);
        System.out.println("Inbuilt function-->"+str.length());
        if (length == str.length()){
            System.out.println("Both the Inbuilt function and the user defined function return the same length of the String.");
        }

        input.close();
    }
}