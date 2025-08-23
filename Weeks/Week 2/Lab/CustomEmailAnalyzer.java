/*Problem 5: Write a program to analyze email addresses
Hint =>
a. Take multiple email addresses as input (comma separated)
b. Create a method to validate email format using simple rules:
   ● i. Must contain '@' and '.'
   ● ii. '@' must appear before '.'
   ● iii. No spaces allowed
c. Extract username and domain parts
d. Count emails by domain
e. Display all results neatly */

import java.util.*;

public class CustomEmailAnalyzer {

    /*b. Validate email */
    public static boolean isValidEmail(String email) {
        if(email.contains(" ") || !email.contains("@") || !email.contains(".")) return false;
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');
        return at > 0 && dot > at;
    }

    /*c. Extract username */
    public static String getUsername(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    /*c. Extract domain */
    public static String getDomain(String email) {
        return email.substring(email.indexOf('@')+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*a. Take input */
        System.out.print("Enter email addresses (comma separated): ");
        String input = sc.nextLine();
        String[] emails = input.split(",");

        Map<String, Integer> domainCount = new HashMap<>();

        System.out.println("\n====== EMAIL ANALYSIS ======");
        System.out.printf("%-30s %-15s %-25s %-10s\n", "Email", "Username", "Domain", "Valid?");
        System.out.println("------------------------------------------------------------------------");

        for(String raw : emails) {
            String email = raw.trim();
            boolean valid = isValidEmail(email);
            String username = valid ? getUsername(email) : "-";
            String domain = valid ? getDomain(email) : "-";
            System.out.printf("%-30s %-15s %-25s %-10s\n", email, username, domain, valid);

            if(valid) {
                domainCount.put(domain, domainCount.getOrDefault(domain, 0)+1);
            }
        }

        /*d. Count by domain */
        System.out.println("\n====== DOMAIN COUNTS ======");
        for(Map.Entry<String,Integer> entry : domainCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        sc.close();
    }
}
