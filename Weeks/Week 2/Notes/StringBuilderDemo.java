public class StringBuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== STRINGBUILDER BASICS ===");
        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity()); // 16
        System.out.println("Initial length: " + sb.length()); // 0

        // Building string with StringBuilder
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        System.out.println("After appends: " + sb.toString());
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());

        System.out.println("\n=== STRINGBUILDER METHODS ===");
        StringBuilder demo = new StringBuilder("Java Programming");
        System.out.println("Original: " + demo);

        // insert(startIndex,String)
        demo.insert(5, "Advanced ");
        System.out.println("After insert: " + demo);

        // Delete
        demo.delete(5, 14); // Remove "Advanced "
        System.out.println("After delete: " + demo);

        // Replace
        demo.replace(5, 16, "Development");
        System.out.println("After replace: " + demo);

        // Reverse
        StringBuilder reverse = new StringBuilder("Hello");
        reverse.reverse();
        System.out.println("Reversed 'Hello': " + reverse);

        // Method chaining
        StringBuilder chain = new StringBuilder();
        String result = chain.append("Java")
                             .append(" is")
                             .append(" awesome")
                             .append("!")
                             .toString();
        System.out.println("Method chaining result: " + result);

        System.out.println("\n=== STRINGBUFFER COMPARISON ===");
        // StringBuffer (thread-safe)
        StringBuffer sbf = new StringBuffer("Thread-Safe");
        sbf.append(" String");
        System.out.println("StringBuffer result: " + sbf);

        // Demonstrate capacity management
        StringBuilder growing = new StringBuilder(5); // Small initial capacity
        System.out.println("Custom initial capacity: " + growing.capacity());
        growing.append("This is a long string that exceeds initial capacity");
        System.out.println("After long append: " + growing.capacity());
        System.out.println("Content: " + growing);
    }
}