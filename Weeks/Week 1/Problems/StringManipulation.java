/*Create a program that demonstrates different ways to create strings and basic
manipulation. */


public class StringManipulation{
    public static void main(String[] args) {
        /* TODO: Create the same string "Java Programming" using 3 different methods:
        1. String literal
        2. new String() constructor
        3. Character array */

        //1->String Literal
        String string = "String Manipulation.";
        System.out.println("String Literal-->"+string);

        //2->new String() constructor 
        String newString = new String("String Manipulation using new() keyword.");
        System.out.println("new String() constructor" + newString);

        //3->Character Array
        char StringArray[] = {'S', 't' , 'r' , 'i' , 'n' ,'g' , ' ' ,'M' , 'a' , 'n' , 'i' , 'p' , 'u' , 'l'
        ,'a' , 't' , 'i' , 'o' , 'n'    };
        String str = new String(StringArray);
        System.out.println("Character Array-->"+str);

        /* TODO: Compare the strings using == and .equals()
        Print the results and explain the difference */
        if(string == str){
            System.out.println("Both the Strings share the same reference to the same string in the String Pool");
        }

        if(string.equals(str)){
            System.out.println("Both the Strings contain the same value(String)");
        }

        /*  TODO: Create a string with escape sequences that displays:
        Programming Quote:"Code is poetry" - Unknown
        Path: C:\Java\Projects*/
        StringBuilder sb = new StringBuilder();
        sb.append("Programming Quote:\"Code is poetry\" - Unknown").append("\nPath: C:\\Java\\Projects");
        System.out.println(sb);
    }
}
