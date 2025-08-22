import java.util.Scanner;

public class Program2{
    public static void main(String args[]){
        Scanner scanner = new Scanner("John,25,Engineer");
        scanner.useDelimiter(","); // Custom delimiter
        String name = scanner.next(); // "John"
        int age = scanner.nextInt(); // 25
        String job = scanner.next(); // "Engineer"

        System.out.println(name);
        System.out.println(age);
        System.out.println(job);
    }
}