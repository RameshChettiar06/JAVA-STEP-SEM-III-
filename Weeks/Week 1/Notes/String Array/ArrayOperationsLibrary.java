import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class ArrayOperationsLibrary{
    public static void main(String args[]){
        Scanner input = new Scanner (System.in);

        String original[] = {"A" , "B", "C"};
        //copyOf(array,array.length)
        String copy[] = Arrays.copyOf(original,original.length);

        //partialArray=Arrays.copyOfRange(original,startIndex,lastIndex)
        String partial[] = Arrays.copyOfRange(original,0,3);

        //Array.equals(array1,array2)-->returns boolean
        boolean equal = Arrays.equals(original,copy);

        System.out.println("original array is the same as copied array-->(true/false)"+equal);

        input.close();
    }
}
