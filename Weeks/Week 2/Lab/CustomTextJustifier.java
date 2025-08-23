/*Problem 6: Write a program to justify text alignment (left, right, center)
Hint =>
a. Take user input text and line width
b. Create methods:
   ● i. Left align: print text as-is within width
   ● ii. Right align: pad spaces before text
   ● iii. Center align: pad spaces on both sides
c. Handle multiple lines if text length > width
d. Display results */

import java.util.*;

public class CustomTextJustifier {

    /*b.i. Left align */
    public static void leftAlign(String text, int width) {
        for(int i=0; i<text.length(); i+=width) {
            System.out.println(text.substring(i, Math.min(i+width, text.length())));
        }
    }

    /*b.ii. Right align */
    public static void rightAlign(String text, int width) {
        for(int i=0; i<text.length(); i+=width) {
            String line = text.substring(i, Math.min(i+width, text.length()));
            System.out.printf("%" + width + "s\n", line);
        }
    }

    /*b.iii. Center align */
    public static void centerAlign(String text, int width) {
        for(int i=0; i<text.length(); i+=width) {
            String line = text.substring(i, Math.min(i+width, text.length()));
            int padding = (width - line.length())/2;
            System.out.printf("%" + (padding + line.length()) + "s\n", line);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*a. Take input */
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter line width: ");
        int width = sc.nextInt();

        System.out.println("\n====== LEFT ALIGN ======");
        leftAlign(text, width);

        System.out.println("\n====== RIGHT ALIGN ======");
        rightAlign(text, width);

        System.out.println("\n====== CENTER ALIGN ======");
        centerAlign(text, width);

        sc.close();
    }
}
