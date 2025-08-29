/*Create a base class and demonstrate how OOP promotes code reusability. */
public class Vehicle{
    // TODO: Create protected instance variables:
    // - make (String)
    // - model (String)
    // - year (int)
    // - fuelLevel (double)
    protected String make, model;
    protected int year;
    protected double fuelLevel;

    // TODO: Create constructor
    Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    // TODO: Create common methods:
    // - startVehicle()
    // - stopVehicle()
    // - refuel(double amount)
    // - displayVehicleInfo()
    public void startVehicle() {
        System.out.println("The vehicle is starting.");
    }
    
    public void stopVehicle() {
        System.out.println("The vehicle is stopping.");
    }
    
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println("The vehicle has been refueled.");
    }
    
    public void displayVehicleInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel + " liters");
    }

    public static void main(String[] args) {
        // TODO: Create different types of vehicles (Car, Truck,Motorcycle)
        Vehicle car = new Vehicle("Tata", "Safari", 2020, 50.0);
        Vehicle truck = new Vehicle("Mahindra", "Bolero", 2019, 80.0);
        Vehicle motorcycle = new Vehicle("Maruti Suzuki", "Wagon-R", 2021, 15.0);
        // TODO: Show how the same Vehicle class can be reused
    
        // TODO: Create an array of Vehicle objects
        Vehicle[] vehicles = {car, truck, motorcycle};

        // TODO: Demonstrate polymorphic behavior
        for (Vehicle vehicle : vehicles) {
            vehicle.startVehicle();
            vehicle.displayVehicleInfo();
            vehicle.stopVehicle();
        }

        // TODO: In comments, explain:
        // - How does this show reusability?
        // The Vehicle class can be reused to create different types of vehicles (car, truck, motorcycle)
        // without duplicating code. Common behaviors are defined in the base class.

        // - What are the benefits over writing separate classes?
        // 1. Code Duplication: Without a base class, common code would need to be duplicated across
        //    multiple vehicle classes, making maintenance harder.
        // 2. Easier Maintenance: Changes to common behavior only need to be made in one place (the base class).
        // 3. Polymorphism: The same interface can be used to interact with different vehicle types.
    }
}
