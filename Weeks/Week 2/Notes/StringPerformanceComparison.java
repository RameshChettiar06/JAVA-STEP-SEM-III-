import java.util.Scanner;

public class StringPerformanceComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== STRING PERFORMANCE COMPARISON ===");
        System.out.print("Enter number of iterations: ");
        int iterations = scanner.nextInt();
        String baseString = "Java";

        System.out.println("\nRunning tests with " + iterations + " iterations...");

        // Method 1: String concatenation (Poor Performance)
        long startTime = System.currentTimeMillis();
        String result1 = stringConcatenation(baseString, iterations);
        long stringTime = System.currentTimeMillis() - startTime;

        // Method 2: StringBuilder (Good Performance)
        startTime = System.currentTimeMillis();
        String result2 = stringBuilderMethod(baseString, iterations);
        long sbTime = System.currentTimeMillis() - startTime;

        // Method 3: StringBuffer (Thread-Safe)
        startTime = System.currentTimeMillis();
        String result3 = stringBufferMethod(baseString, iterations);
        long sbfTime = System.currentTimeMillis() - startTime;

        // Method 4: Optimized StringBuilder
        startTime = System.currentTimeMillis();
        String result4 = stringBuilderOptimized(baseString, iterations);
        long sbOptTime = System.currentTimeMillis() - startTime;

        // Display results
        System.out.println("\n=== PERFORMANCE RESULTS ===");
        System.out.println("String concatenation:        " + stringTime + " ms");
        System.out.println("StringBuilder:               " + sbTime + " ms");
        System.out.println("StringBuffer:                " + sbfTime + " ms");
        System.out.println("StringBuilder (optimized):   " + sbOptTime + " ms");

        System.out.println("\n=== PERFORMANCE RATIOS ===");
        System.out.printf("StringBuilder is %.2fx faster than String%n", (double) stringTime / sbTime);
        System.out.printf("StringBuffer is %.2fx faster than String%n", (double) stringTime / sbfTime);
        System.out.printf("Optimized StringBuilder is %.2fx faster than String%n", (double) stringTime / sbOptTime);

        // Verify correctness
        boolean allEqual = result1.equals(result2) && result2.equals(result3) && result3.equals(result4);
        System.out.println("\nAll results equal: " + allEqual);
        System.out.println("Final string length: " + result1.length());

        scanner.close();
    }

    public static String stringConcatenation(String base, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += base;
        }
        return result;
    }

    public static String stringBuilderMethod(String base, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(base);
        }
        return sb.toString();
    }

    public static String stringBufferMethod(String base, int count) {
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sbf.append(base);
        }
        return sbf.toString();
    }

    public static String stringBuilderOptimized(String base, int count) {
        StringBuilder sb = new StringBuilder(base.length() * count);
        for (int i = 0; i < count; i++) {
            sb.append(base);
        }
        return sb.toString();
    }
}       