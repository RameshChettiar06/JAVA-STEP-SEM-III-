import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderProgram {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a sentence: ");
        String sentence = reader.readLine();

        System.out.print("Enter your age: ");
        String ageStr = reader.readLine();
        int age = Integer.parseInt(ageStr); // manual conversion

        System.out.println("You entered: " + sentence);
        System.out.println("Your age: " + age);

        // No need to close reader here, avoids closing System.in
    }
}
