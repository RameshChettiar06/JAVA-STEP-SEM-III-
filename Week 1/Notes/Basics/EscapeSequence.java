/*Escape sequences in Java are special characters preceded by a backslash (\) that are
used to represent characters that are otherwise difficult or impossible to include directly in a
string.
They help in:
● Formatting strings.
● Representing special characters (like quotes or newlines).
● Avoiding compile-time errors */

public class EscapeSequence {
    public static void main(String[] args) {
        // Common escape sequences
        String newline = "Line 1\nLine 2";
        String tab = "Column1\tColumn2";
        String quote = "He said \"Hello\"";
        String backslash = "Path: C:\\Users\\Java";
        String carriageReturn = "First\rSecond";
        String backspace = "Hello\bWorld";
        String formFeed = "Page1\fPage2";
        // Unicode escape - must be exactly 4 hex digits
        String unicode = "\u0048\u0065\u006C\u006C\u006F"; // "Hello"
        // Octal escape (legacy, not recommended)
        String octal = "\110\145\154\154\157"; // "Hello"
        System.out.println("Newline:\n" + newline);
        System.out.println("Tab:\n" + tab);
        System.out.println("Quote: " + quote);
        System.out.println("Backslash: " + backslash);
        System.out.println("Unicode: " + unicode);
        System.out.println(carriageReturn);
        System.out.println(backspace);
        System.out.println(formFeed);
    }
}