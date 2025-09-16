 class Car {
    private String brand;
    private int year;
    // No constructor defined - Java creates default constructor
    // Equivalent to:
    // public Car() {
    // super(); // implicit call to Object constructor
    
}

public class DefaultConstructor{
    public static void main(String[] args) {
        Car car = new Car(); // Uses default constructor
        // brand = null, year = 0 (default values)
    }
}