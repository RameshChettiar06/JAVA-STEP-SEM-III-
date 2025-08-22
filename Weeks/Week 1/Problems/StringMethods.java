/* Create a program that takes user input and processes it using various string methods.*/

import java.util.Scanner;

public class StringMethods{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        // TODO: Ask user for their full name (first and last name)
        //Using trim() to remove padding at the start and end of strings
        System.out.print("Enter your full name(first and last name):");
        String fullName = scanner.nextLine().trim();
        
        // TODO: Ask user for their favorite programming language
        System.out.print("Enter your favorite programming language:");
        String favorite = scanner.next().trim();
        scanner.nextLine();//Removes/Consumes leftover newline[\n]

        // TODO: Ask user for a sentence about their programming experience
        System.out.print("Enter a sentence about your programming experience:");
        String opinion = scanner.nextLine().trim();

        /* TODO: Process the input:
           1. Extract first and last name separately
           2. Count total characters in the sentence (excluding spaces)
           3. Convert programming language to uppercase
           4. Display a formatted summary*/
        
        //1->Extracting first and last name separately
        String words[] = fullName.split(" ");//using split() to separate words
        String firstName = words[0];
        String lastName = words[words.length - 1];//words.length tells us how many words there were in total
 

        //2-->Counting total characters in the sentence excluding spaces
        int totalCharacters = opinion.length();
        for(int i = 0; i < opinion.length(); i++){
            if (opinion.charAt(i) == ' '){
                totalCharacters--;
            }
        }
        

        //3-->Convert programming language to uppercase
        String uppercase = favorite.toUpperCase();

        //4-->Display a formatted summary
        System.out.println("\n------------INPUT DETAILS------------");
        System.out.println("Full Name-->"+fullName);
        System.out.println("Favorite Programming Language-->" + favorite);
        System.out.println("Sentence about Programming Experience-->" + opinion);
        System.out.println("\n-----------FORMATTED SUMMARY-----------");
        System.out.println("First Name-->" + firstName + "\nLast Name-->" + lastName);
        System.out.println("Total Characters in the Sentence Excluding Spaces-->"+totalCharacters);
        System.out.println("Favorite Programming Language to Uppercase-->"+uppercase);
        scanner.close();
    }
}