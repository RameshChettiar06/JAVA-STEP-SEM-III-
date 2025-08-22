import java.util.Scanner;

public class BMI {
    static Scanner input = new Scanner(System.in);

    //Function to take Height and Weight as Input
    public static double[][] weightHeight() {
        double[][] stats = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + " :");
            System.out.print("Weight of Person (in kgs): ");
            stats[i][0] = input.nextDouble();
            System.out.print("Height of Person (in cms): ");
            stats[i][1] = input.nextDouble();
        }
        return stats;
    }


    //Function to store all 4 values
    public static String[][] Statistics(double[][] stats) {
        String[][] data = new String[10][4];
        for (int i = 0; i < 10; i++) {
            double heightM = stats[i][1] / 100;
            double BMI = stats[i][0] / (Math.pow(heightM, 2));

            data[i][0] = String.valueOf(stats[i][1]);              // height
            data[i][1] = String.valueOf(stats[i][0]);              // weight
            data[i][2] = String.format("%.2f", BMI);               // BMI
            if (BMI > 0 && BMI <= 18.4) {
                data[i][3] = "Underweight";
            } else if (BMI > 18.4 && BMI <= 24.9) {
                data[i][3] = "Normal";
            } else if (BMI > 24.9 && BMI <= 39.9) {
                data[i][3] = "Overweight";
            } else if (BMI < 0) {
                data[i][3] = "Invalid BMI";
            } else {
                data[i][3] = "Obese";
            }
        }
        return data;
    }



    //Function to display Details
    public static void displayDetails(String[][] data) {
        System.out.println("\n===================== DETAILS =====================");
        System.out.printf("%-12s %-12s %-12s %-15s\n", "Height(cms)", "Weight(kgs)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-12s %-12s %-12s %-15s\n",
                    data[i][0], data[i][1], data[i][2], data[i][3]);
        }
    }

    //Main()
    public static void main(String[] args) {
        double[][] HeightWeight = weightHeight();
        String[][] DATA = Statistics(HeightWeight);
        displayDetails(DATA);
        input.close();
    }
}
