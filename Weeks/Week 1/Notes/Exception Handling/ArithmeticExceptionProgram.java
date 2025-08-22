import java.io.IOException;
import java.util.Scanner;

public class ArithmeticExceptionProgram{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Numerator-->");
        int num = input.nextInt();

        System.out.println("Enter Denominator-->");
        int den = input.nextInt();

        try{
            int result = num/den;
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
            System.out.println("Division by 0");
        }

        System.out.println(num/den);

        input.close();
    }
}