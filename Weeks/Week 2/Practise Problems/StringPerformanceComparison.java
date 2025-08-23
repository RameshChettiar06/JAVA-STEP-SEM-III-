public class StringPerformanceComparison {
    public static void main(String[] args) {
        // TODO: Implement performance tests for different approaches
        System.out.println("====== PERFORMANCE COMPARISON ======");

        // TODO: Test string concatenation with regular String (slow method)
        long startTime = System.nanoTime();
        String result1 = concatenateWithString(10000);
        long endTime = System.nanoTime();
        System.out.println("String concatenation time: " + (endTime - startTime) + " ns");

        // TODO: Test string concatenation with StringBuilder (fast method)
        startTime = System.nanoTime();
        String result2 = concatenateWithStringBuilder(10000);
        endTime = System.nanoTime();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + " ns");

        // TODO: Test string concatenation with StringBuffer (thread-safe method)
        startTime = System.nanoTime();
        String result3 = concatenateWithStringBuffer(10000);
        endTime = System.nanoTime();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + " ns");

        // TODO: Demonstrate StringBuilder methods
        System.out.println("\n====== STRINGBUILDER METHODS DEMO ======");
        demonstrateStringBuilderMethods();

        // TODO: Demonstrate thread safety differences
        System.out.println("\n====== THREAD SAFETY DEMO ======");
        demonstrateThreadSafety();

        // TODO: Compare string comparison methods
        System.out.println("\n====== STRING COMPARISON METHODS ======");
        compareStringComparisonMethods();

        // TODO: Demonstrate memory efficiency
        System.out.println("\n====== MEMORY EFFICIENCY DEMO ======");
        demonstrateMemoryEfficiency();
    }

    // TODO: Method using String concatenation (inefficient)
    public static String concatenateWithString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "Java" + i + " ";
        }
        return result;
    }

    // TODO: Method using StringBuilder (efficient, not thread-safe)
    public static String concatenateWithStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    // TODO: Method using StringBuffer (efficient, thread-safe)
    public static String concatenateWithStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("Java").append(i).append(" ");
        }
        return sb.toString();
    }

    // TODO: Method to demonstrate StringBuilder methods
    public static void demonstrateStringBuilderMethods() {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("Original: " + sb);

        // 1. append()
        sb.append(" Java");
        System.out.println("After append: " + sb);

        // 2. insert()
        sb.insert(6, "Beautiful ");
        System.out.println("After insert: " + sb);

        // 3. delete()
        sb.delete(6, 16);
        System.out.println("After delete: " + sb);

        // 4. deleteCharAt()
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb);

        // 5. reverse()
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // 6. replace()
        sb.reverse().replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);

        // 7. setCharAt()
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt: " + sb);

        // 8. capacity()
        System.out.println("Capacity: " + sb.capacity());

        // 9. ensureCapacity()
        sb.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): " + sb.capacity());

        // 10. trimToSize()
        sb.trimToSize();
        System.out.println("After trimToSize: " + sb.capacity());
    }

    // TODO: Method to demonstrate StringBuffer thread safety
    public static void demonstrateThreadSafety() {
        StringBuffer safeBuffer = new StringBuffer("Start");
        StringBuilder unsafeBuilder = new StringBuilder("Start");

        Runnable taskBuffer = () -> {
            for (int i = 0; i < 1000; i++) {
                safeBuffer.append("X");
            }
        };
        Runnable taskBuilder = () -> {
            for (int i = 0; i < 1000; i++) {
                unsafeBuilder.append("X");
            }
        };

        Thread t1 = new Thread(taskBuffer);
        Thread t2 = new Thread(taskBuffer);
        Thread t3 = new Thread(taskBuilder);
        Thread t4 = new Thread(taskBuilder);

        t1.start(); t2.start();
        t3.start(); t4.start();

        try {
            t1.join(); t2.join();
            t3.join(); t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuffer length (thread-safe): " + safeBuffer.length());
        System.out.println("StringBuilder length (not thread-safe): " + unsafeBuilder.length());
    }

    // TODO: Method to compare string comparison methods
    public static void compareStringComparisonMethods() {
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        // 1. == operator
        System.out.println("== operator (str1 == str2): " + (str1 == str2));
        System.out.println("== operator (str1 == str3): " + (str1 == str3));

        // 2. equals()
        System.out.println("equals() (str1.equals(str3)): " + str1.equals(str3));

        // 3. equalsIgnoreCase()
        System.out.println("equalsIgnoreCase() (\"hello\"): " + str1.equalsIgnoreCase("hello"));

        // 4. compareTo()
        System.out.println("compareTo(\"Hello\"): " + str1.compareTo("Hello"));
        System.out.println("compareTo(\"World\"): " + str1.compareTo("World"));

        // 5. compareToIgnoreCase()
        System.out.println("compareToIgnoreCase(\"hello\"): " + str1.compareToIgnoreCase("hello"));
    }

    // TODO: Method to demonstrate memory efficiency
    public static void demonstrateMemoryEfficiency() {
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        // String pool behavior
        System.out.println("String Pool test: (str1 == str2): " + (str1 == str2));
        System.out.println("String Pool test: (str1 == str3): " + (str1 == str3));

        // StringBuilder capacity management
        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());
        sb.append("This is a test string to check capacity growth...");
        System.out.println("After appending text, capacity: " + sb.capacity());
    }
}