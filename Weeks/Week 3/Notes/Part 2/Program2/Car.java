public class Car {
    // TODO: Define instance variables (attributes):
    // - brand (String)
    // - model (String)
    // - year (int)
    // - color (String)
    // - isRunning (boolean)
    private String brand, model, color;
    private int year;
    private boolean isRunning;

    // TODO: Create a constructor that initializes all attributes
    public Car(String brand, String model, String color, int year, boolean isRunning){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.isRunning = isRunning;
    }

    // TODO: Create instance methods:
    // - startEngine() - sets isRunning to true, prints message
    // - stopEngine() - sets isRunning to false, prints message
    // - displayInfo() - prints all car information
    // - getAge() - returns current year minus car year

    public static void startEngine(){
        isRunning = "true";
        System.out.println("Engine of the car has Started!");
    }

    public static void stopEngine(){
        isRunning = "false";
        System.out.println("Engine of the car has Stopped!");
    }

    public static void getAge(){
        return 2025 - year;
    }
    
    public static void displayInfo(){
        System.out.println("===============CAR DETAILS===============");
        System.out.println("Car Brand-->" + brand);
        System.out.println("Car Model-->" + model);
        System.out.println("Car Color-->" + color);
        System.out.println("Purchasing Year of Car-->" + year);
        System.out.println("Years of Ownership-->" + getAge());
        System.out.println("Is the Engine Running?-->" +isRunning);
    }

    public static void main(String[] args) {
    // TODO: Create 3 different Car objects with different attributes
    Car car1 = new Car("TATA","PUNCH-EV","red",2023,false);
    Car car1 = new Car("TATA","PUNCH-EV","green",2022,true);
    Car car1 = new Car("TATA","PUNCH-EV","blue",2021,false);
    // TODO: Demonstrate calling methods on each object
    // TODO: Show how each object maintains its own state
    // TODO: Explain in comments: How is this similar to real-world cars?
    }
}