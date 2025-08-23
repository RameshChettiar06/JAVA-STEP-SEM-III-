import java.util.*;

public class CustomTextBasedFileOrganizer {

    // ===============================
    // Category mappings for extensions
    // ===============================
    private static final Map<String, String> categories = new HashMap<>();
    static {
        categories.put("txt", "Document");
        categories.put("doc", "Document");
        categories.put("jpg", "Image");
        categories.put("png", "Image");
        categories.put("pdf", "PDF");
        categories.put("java", "Code");
        categories.put("c", "Code");
    }

    // ----------------------------------------------------
    // (b) Validate file name format (only letters, numbers,
    // underscores, hyphens and must contain an extension)
    // ----------------------------------------------------
    public static boolean validateFileName(String file) {
        return file.matches("^[a-zA-Z0-9._-]+\\.[a-zA-Z0-9]+$");
    }

    // ----------------------------------------------------
    // (b) Extract components using lastIndexOf() and substring()
    // ----------------------------------------------------
    public static String[] extractComponents(String file) {
        int dotIndex = file.lastIndexOf('.');
        String name = file.substring(0, dotIndex);
        String ext = file.substring(dotIndex + 1).toLowerCase();
        return new String[]{name, ext};
    }

    // ----------------------------------------------------
    // (c) Categorize files by extension
    // ----------------------------------------------------
    public static String categorize(String ext) {
        return categories.getOrDefault(ext, "Unknown");
    }

    // ----------------------------------------------------
    // (e) Simulate content-based analysis for .txt files
    // ----------------------------------------------------
    public static String analyzeContent(String file) {
        if (!file.endsWith(".txt")) return "N/A";

        // Fake keyword-based detection (demo only)
        if (file.toLowerCase().contains("resume")) return "Resume";
        if (file.toLowerCase().contains("report")) return "Report";
        if (file.toLowerCase().contains("code")) return "Code";
        return "GeneralText";
    }

    // ----------------------------------------------------
    // (d) Generate new filename using category + date + index
    // ----------------------------------------------------
    public static String generateNewName(String category, String ext, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(category).append("_2025_").append(count).append(".").append(ext);
        return sb.toString();
    }

    // ----------------------------------------------------
    // (f) Display file organization report
    // ----------------------------------------------------
    public static void displayReport(List<String[]> files, Map<String, Integer> counts) {
        System.out.println("\n=== File Organization Report ===");
        System.out.printf("%-20s %-12s %-20s %-15s\n", "Original Name", "Category", "New Name", "Subcategory");
        System.out.println("----------------------------------------------------------------------");

        for (String[] file : files) {
            System.out.printf("%-20s %-12s %-20s %-15s\n", file[0], file[1], file[2], file[3]);
        }

        System.out.println("\n--- Category Counts ---");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // ----------------------------------------------------
    // (g) Generate batch rename commands
    // ----------------------------------------------------
    public static void batchRename(List<String[]> files) {
        System.out.println("\n--- Batch Rename Commands ---");
        for (String[] file : files) {
            System.out.println("rename " + file[0] + " → " + file[2]);
        }
    }

    // ----------------------------------------------------
    // (h) Main function to process file list
    // ----------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> reportData = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter file name " + (i + 1) + ": ");
            String file = sc.nextLine();

            // b(iii) Validate file name
            if (!validateFileName(file)) {
                System.out.println("❌ Invalid file name: " + file);
                reportData.add(new String[]{file, "Invalid", "N/A", "N/A"});
                continue;
            }

            // b(ii) Extract name & extension
            String[] parts = extractComponents(file);
            String name = file;
            String ext = parts[1];

            // c(i) Categorize
            String category = categorize(ext);
            counts.put(category, counts.getOrDefault(category, 0) + 1);

            // d(i) Generate new filename
            String newName = generateNewName(category, ext, counts.get(category));

            // e(i) Simulate content analysis
            String subCategory = analyzeContent(file);

            // Store report row
            reportData.add(new String[]{name, category, newName, subCategory});
        }

        // f(i) Display report
        displayReport(reportData, counts);

        // g(i) Show batch rename simulation
        batchRename(reportData);

        sc.close();
    }
}
