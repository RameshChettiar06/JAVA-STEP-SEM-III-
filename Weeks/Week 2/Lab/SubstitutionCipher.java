/*Problem 4: Write a program to implement a simple Substitution Cipher 
(Caesar Cipher) for encryption and decryption
Hint =>
a. Take user input for a plain text string
b. Take user input for a key (shift value)
c. Create a method for encryption:
   ● i. Convert each character using (char + shift)
   ● ii. Ensure wrapping using modulo for alphabets
d. Create a method for decryption:
   ● i. Convert each character using (char - shift)
   ● ii. Ensure wrapping using modulo
e. Display both encrypted and decrypted results along with the shift value */

import java.util.Scanner;

public class SubstitutionCipher {

    // c. Encryption method using Caesar Cipher
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { 
                result.append((char) (((c - 'A' + shift) % 26) + 'A'));
            } 
            else if (c >= 'a' && c <= 'z') { 
                result.append((char) (((c - 'a' + shift) % 26) + 'a'));
            } 
            else {
                result.append(c); // keep symbols/numbers as is
            }
        }
        return result.toString();
    }

    // d. Decryption method using Caesar Cipher
    public static String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { 
                result.append((char) (((c - 'A' - shift + 26) % 26) + 'A'));
            } 
            else if (c >= 'a' && c <= 'z') { 
                result.append((char) (((c - 'a' - shift + 26) % 26) + 'a'));
            } 
            else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // a. Take user input for plain text
        System.out.print("Enter a plain text: ");
        String plainText = input.nextLine();

        // b. Take user input for key (shift value)
        System.out.print("Enter a shift key (public key): ");
        int shift = input.nextInt();

        // Encryption & Decryption
        String encrypted = encrypt(plainText, shift);
        String decrypted = decrypt(encrypted, shift);

        // e. Display results including the public key
        System.out.println("\n====== SUBSTITUTION CIPHER RESULTS ======");
        System.out.println("Public Key (Shift): " + shift);
        System.out.println("Original Text      : " + plainText);
        System.out.println("Encrypted Text     : " + encrypted);
        System.out.println("Decrypted Text     : " + decrypted);

        input.close();
    }
}
