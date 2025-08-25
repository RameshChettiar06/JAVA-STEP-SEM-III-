 public static void displayASCIITable(int start, int end) {
        // Display ASCII codes and corresponding characters
        for (int i = start; i <= end; i++) {
            System.out.printf("%3d : %c   ", i, (char) i);
            if ((i - start + 1) % 8 == 0) System.out.println();
        }
        System.out.println();
    }