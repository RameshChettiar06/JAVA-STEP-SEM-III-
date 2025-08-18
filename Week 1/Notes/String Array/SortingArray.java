import java.util.Scanner;
import java.util.Arrays;

public class SortingArray{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String unsorted[] = new String[3];
        for (int i = 0 ; i < 3; i++){
            unsorted[i] = input.next();
        }

        //Sorting Original Array
        Arrays.sort(unsorted);

        System.out.println("Enter element to be searched-->");
        
        //Binary Search
        String element = input.next();
        int index = Arrays.binarySearch(unsorted,element);
        System.out.println(index);
        //Conevrting String Array to a String Literal
        String string = Arrays.toString(unsorted);
        System.out.println(string);

        input.close();
    }
}
