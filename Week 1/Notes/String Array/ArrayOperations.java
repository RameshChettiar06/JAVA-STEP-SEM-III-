import java.util.Scanner;
import java.io.IOException;

public class ArrayOperations{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        String languages[] = {"JAVA" , "C++" , "PYTHON"};

        System.out.println("Number of Languages-->" + languages.length);

        //Normal Iteration
        for (int i = 0; i < languages.length; i++){
            System.out.println("languages[" + i + "]-->"+languages[i]);
        }

        //For each loop
        for (String language : languages){
            System.out.println(language);
        }
        
        //.indexOf(num)........ .charAt('ch')..... .contains()... .substring(startIndex,lastIndex).... .
        //.equalsIgnoreCase(string)...... .startsWith(String)........... .endsWith(String)
        
        //Exception Handling

        try{
            System.out.println(languages[10]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out of Bounds!");
        }

        input.close();
    }
}