// File: ShapeDemo.java

// Abstract base class for all shapes
abstract class Shape {
    protected String color;

    // Abstract method to be implemented by each shape subclass
    public abstract double calculateArea();

    // Common method to display shape information
    public void displayInfo() {
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("---------------------------");
    }
}

// Extending functionality - Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Extending functionality - Rectangle
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Extending functionality - Triangle
class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height, String color) {
        this.base = base;
        this.height = height;
        this.color = color;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Client code works with any shape without modification
class ShapeProcessor {
    public void processShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.displayInfo(); // Polymorphic call
        }
    }
}

// Main class to demonstrate polymorphism
public class ShapeDemo {
    public static void main(String[] args) {
        System.out.println("=== Shape Processing Demo ===\n");

        // Creating various shapes
        Shape circle = new Circle(5.0, "Red");
        Shape rectangle = new Rectangle(4.0, 6.0, "Blue");
        Shape triangle = new Triangle(3.0, 7.0, "Green");

        // Storing shapes in an array
        Shape[] shapes = { circle, rectangle, triangle };

        // Processing shapes using polymorphism
        ShapeProcessor processor = new ShapeProcessor();
        processor.processShapes(shapes);
    }
}