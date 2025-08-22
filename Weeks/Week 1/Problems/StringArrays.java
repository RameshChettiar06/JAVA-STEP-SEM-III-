/*Task: Create a program that manages a list of student names using string arrays and methods. */


public class StringArrays{
    
    // TODO: Create a method that takes a string array of names
    // and returns the longest name
    public static String findLongestName(String[] names) {
        // Your code here
         String longestName = names[0].trim();  // start with the first name
        for (String name : names) {
            if (name.trim().length() > longestName.length()) {
                longestName = name.trim();
            }
        }
            return longestName;
        }

    
        // TODO: Create a method that counts how many names
    // start with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        // Your code here
         int count = 0;
         letter = Character.toLowerCase(letter); // Deals with edge cases
            for (String name : names) {
                if (Character.toLowerCase(name.trim().charAt(0)) == letter) {
                    count++;
                }
            }
            return count;
        }
    
    
    
        // TODO: Create a method that formats all names to "Last, First" format
    // Assume names are given as "First Last"
    public static String[] formatNames(String[] names) {
        // Your code here
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].trim().split(" ");
            if (parts.length >= 2) {
                String first = parts[0];
                String last = parts[parts.length - 1];
                formatted[i] = last + ", " + first;
            } else {
                formatted[i] = names[i]; // fallback if only one word
            }
        }
        return formatted;
        }


    public static void main(String args[]){
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown","Carol Davis", "David Wilson"};
        // TODO: Test all your methods and display results
        System.out.println("Longest Name: " + findLongestName(students));
        System.out.println("Names starting with D: " + countNamesStartingWith(students, 'D'));
        String[] formattedNames = formatNames(students);
        System.out.println("\nFormatted Names:");
        for (String name : formattedNames) {
            System.out.println(name);
        }
        
    }
}