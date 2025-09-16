public class Vehicle {
    // Private instance variables
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    // Static variables
    private static int totalVehicles = 0;
    private static double totalRevenue = 0.0;
    private static String companyName = "Default Rental Company";
    private static int rentalDays = 0;
    private static int vehicleCounter = 0;

    // Constructor
    public Vehicle(String brand, String model, double rentPerDay) {
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.vehicleId = generateVehicleId();
        totalVehicles++;
    }

    // Private static method to generate vehicle ID
    private static String generateVehicleId() {
        vehicleCounter++;
        return String.format("V%03d", vehicleCounter);
    }

    // Static method to set company name
    public static void setCompanyName(String name) {
        companyName = name;
    }

    // Static method to get total revenue
    public static double getTotalRevenue() {
        return totalRevenue;
    }

    // Static method to get average rent per day
    public static double getAverageRentPerDay() {
        if (rentalDays > 0) {
            return totalRevenue / rentalDays;
        } else {
            return 0.0;
        }
    }

    // Static method to display company stats
    public static void displayCompanyStats() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Rent Per Day: $" + getAverageRentPerDay());
        System.out.println("-----------------------------");
    }

    // Instance method to calculate rent
    public double calculateRent(int days) {
        return days * rentPerDay;
    }

    // Instance method to rent vehicle
    public void rentVehicle(int days) {
        if (isAvailable && days > 0) {
            double rent = calculateRent(days);
            totalRevenue += rent;
            rentalDays += days;
            isAvailable = false;
            System.out.println("Vehicle " + vehicleId + " rented for " + days + " days. Rent: $" + rent);
        } else if (!isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is not available.");
        } else {
            System.out.println("Invalid number of days.");
        }
    }

    // Instance method to return vehicle
    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned and is now available.");
        } else {
            System.out.println("Vehicle " + vehicleId + " is already available.");
        }
    }

    // Instance method to display vehicle info
    public void displayVehicleInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent Per Day: $" + rentPerDay);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("-----------------------------");
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Set company name
        Vehicle.setCompanyName("Super Rentals");

        // Create an array of Vehicle objects
        Vehicle[] vehicles = new Vehicle[3];

        // Create multiple vehicles
        vehicles[0] = new Vehicle("Toyota", "Highlander", 4000.0);
        vehicles[1] = new Vehicle("Honda", "BR-V", 4500.0);
        vehicles[2] = new Vehicle("Ford", "Endeavour", 8000.0);

        // Display company stats initially
        System.out.println("Initial Company Stats:");
        Vehicle.displayCompanyStats();

        // Perform rentals
        vehicles[0].rentVehicle(3); // Rent for 3 days
        vehicles[1].rentVehicle(5); // Rent for 5 days
        vehicles[2].rentVehicle(2); // Rent for 2 days

        // Try to rent an unavailable vehicle
        vehicles[0].rentVehicle(1); // Should fail

        // Display vehicle info
        System.out.println("\nVehicle Information:");
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
        }

        // Return vehicles
        vehicles[0].returnVehicle();
        vehicles[1].returnVehicle();

        // Display updated company stats
        System.out.println("Updated Company Stats:");
        Vehicle.displayCompanyStats();

        // Demonstrate static vs instance
        System.out.println("\nDemonstrating static vs instance:");
        System.out.println("Total Vehicles (static): " + Vehicle.totalVehicles);
        System.out.println("Total Revenue (static): INR." + Vehicle.getTotalRevenue());
        System.out.println("Vehicle 0 Available (instance): " + vehicles[0].isAvailable);
        System.out.println("Vehicle 1 Available (instance): " + vehicles[1].isAvailable);
        System.out.println("Vehicle 2 Available (instance): " + vehicles[2].isAvailable);
    }
}