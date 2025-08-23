/*Problem 2: Write a program to calculate the strength of a password
Hint =>
a. Take user input for a password string
b. Check for different criteria:
   ● i. Length of password (minimum 8 characters)
   ● ii. Contains uppercase and lowercase letters
   ● iii. Contains digits
   ● iv. Contains special characters
c. Assign points for each criterion and calculate total score
d. Display strength level as Weak, Moderate, or Strong
*/

import java.util.Scanner;

public class CustomPasswordStrengthCalculator {

    /* b. Check for different criteria */
    public static int calculateStrength(String password) {
        int score = 0;

        // i. Length
        if (password.length() >= 8) score++;

        // ii. Uppercase + lowercase
        if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")) score++;

        // iii. Digits
        if (password.matches(".*[0-9].*")) score++;

        // iv. Special chars
        if (password.matches(".*[^a-zA-Z0-9].*")) score++;

        return score;
    }

    /* d. Display strength level */
    public static String strengthLevel(int score) {
        switch (score) {
            case 4: return "Strong";
            case 3: return "Moderate";
            default: return "Weak";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String pwd = sc.nextLine();

        int score = calculateStrength(pwd);
        String level = strengthLevel(score);

        System.out.println("\nPassword Strength: " + level + " (Score: " + score + "/4)");
        sc.close();
    }
}
