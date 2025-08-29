/*Create a program that demonstrates the concept of classes and objects using a
real-world analogy. */
import java.util.Scanner;

public class Car{
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
    public Car(String brand, String model, int year, String color){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // Car is initially off
    }

    // TODO: Create instance methods:
    // - startEngine() - sets isRunning to true, prints message
    // - stopEngine() - sets isRunning to false, prints message
    // - displayInfo() - prints all car information
    // - getAge() - returns current year minus car year
    public void startEngine(){
        if(!isRunning){
            isRunning = true;
            System.out.println("The engine has started.");
        } else {
            System.out.println("The engine is already running.");
        }
    }

    public void stopEngine(){
        if(isRunning){
            isRunning = false;
            System.out.println("The engine has stopped.");
        } else {
            System.out.println("The engine is already off.");
        }
    }

    public void displayInfo(){
        System.out.println("Car Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + (isRunning ? "Yes" : "No"));
    } 

    public int getAge(){
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - year;
    }

    public static void main(String[] args) {
        // TODO: Create 3 different Car objects with different attributes
        // TODO: Demonstrate calling methods on each object
        // TODO: Show how each object maintains its own state
        // TODO: Explain in comments: How is this similar to real-world cars?
        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
        Car car2 = new Car("Honda", "Civic", 2018, "Red");
        Car car3 = new Car("Ford", "Mustang", 2021, "Black");

        car1.startEngine();
        car1.displayInfo();
        System.out.println("Car Age: " + car1.getAge() + " years");
        car1.stopEngine();

        car2.startEngine();
        car2.displayInfo();
        System.out.println("Car Age: " + car2.getAge() + " years");
        car2.stopEngine();

        car3.startEngine();
        car3.displayInfo();
        System.out.println("Car Age: " + car3.getAge() + " years");
        car3.stopEngine();

        
        /* Each Car object represents a real-world car with specific attributes (brand, model, year, color)
         and behaviors (starting/stopping the engine, displaying information).
         Just like real cars, each Car object maintains its own state (e.g., whether it's running or not)
         and can perform actions independently of other Car objects. */
    }
}