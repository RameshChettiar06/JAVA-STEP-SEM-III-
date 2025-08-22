import java.util.Scanner;

public class ScannerProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            System.out.println("You entered: " + sentence);
            System.out.println("Your age: " + age);
        }
    }
}
