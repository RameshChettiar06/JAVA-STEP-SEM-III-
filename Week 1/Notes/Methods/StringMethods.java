public class StringMethods {
    // Method accepting string parameter
    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Method returning modified string
    public static String formatName(String firstName, String lastName) {
        return lastName.toUpperCase() + ", " + firstName;
    }

    // Method with string array parameter
    public static void printAllNames(String[] names) {
        for (String name : names) {
            if (name != null) {
                printGreeting(name);
            }
        }
    }

    // Method demonstrating string immutability
    public static void tryToModify(String str) {
        System.out.println("Original parameter: " + str);
        str = "Modified";
        System.out.println("Inside method: " + str);
    }

    // Method with multiple string parameters
    public static String buildAddress(String street, String city, String state, String zip) {
        return street + ", " + city + ", " + state + " " + zip;
    }

    // Method demonstrating null handling
    public static String safeConcat(String str1, String str2) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        return str1 + str2;
    }

    // Varargs method
    public static String joinStrings(String delimiter, String... strings) {
        if (strings.length == 0) return "";
        StringBuilder result = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            result.append(delimiter).append(strings[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        printGreeting("Alice");

        String formatted = formatName("John", "Doe");
        System.out.println("Formatted: " + formatted);

        String[] team = {"Alice", "Bob", "Charlie"};
        printAllNames(team);

        String original = "Original";
        System.out.println("Before method call: " + original);
        tryToModify(original);
        System.out.println("After method call: " + original);

        String address = buildAddress("123 Main St", "Anytown", "CA", "12345");
        System.out.println("Address: " + address);

        String result = safeConcat("Hello", null);
        System.out.println("Safe concat: '" + result + "'");

        String joined = joinStrings(" - ", "Java", "Python", "JavaScript");
        System.out.println("Joined: " + joined);
    }
}
