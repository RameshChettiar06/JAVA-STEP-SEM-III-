// File: VehicleDemo.java

// Base class - reusable across different vehicle types
class Vehicle {
    protected String brand;
    protected int year;

    // Display basic vehicle info
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

// Reusing Vehicle class through inheritance
class Car extends Vehicle {
    private int doors;

    // Constructor for Car - sets brand, year, and number of doors
    public Car(String brand, int year, int doors) {
        this.brand = brand;
        this.year = year;
        this.doors = doors;
    }

    // Reusing parent method + adding specific behavior
    @Override
    public void displayInfo() {
        super.displayInfo(); // Reusing parent implementation
        System.out.println("Doors: " + doors);
    }
}

// Reusing through composition
class Garage {
    private Vehicle[] vehicles; // Reusing Vehicle objects
    private int count;

    // Constructor to initialize garage with capacity
    public Garage(int capacity) {
        vehicles = new Vehicle[capacity];
        count = 0;
    }

    // Add any Vehicle subclass to the garage
    public void addVehicle(Vehicle vehicle) {
        if (count < vehicles.length) {
            vehicles[count] = vehicle;
            count++;
            System.out.println("✅ Vehicle added to garage.");
        } else {
            System.out.println("🚫 Garage is full. Cannot add more vehicles.");
        }
    }

    // Display all vehicles in the garage
    public void showGarageContents() {
        System.out.println("\n🚗 === Garage Contents ===");
        for (int i = 0; i < count; i++) {
            vehicles[i].displayInfo();
        }
    }
}

// Main class to demonstrate inheritance and composition
public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("=== Vehicle System Demo ===\n");

        // Creating vehicles
        Vehicle bike = new Vehicle();
        bike.brand = "Yamaha";
        bike.year = 2020;

        Car sedan = new Car("Honda", 2022, 4);
        Car suv = new Car("Toyota", 2023, 5);

        // Displaying individual vehicle info
        System.out.println("🔍 Individual Vehicle Info:");
        bike.displayInfo();
        sedan.displayInfo();
        suv.displayInfo();

        // Creating a garage and adding vehicles
        Garage myGarage = new Garage(5);
        myGarage.addVehicle(bike);
        myGarage.addVehicle(sedan);
        myGarage.addVehicle(suv);

        // Showing all vehicles in the garage
        myGarage.showGarageContents();
    }
}