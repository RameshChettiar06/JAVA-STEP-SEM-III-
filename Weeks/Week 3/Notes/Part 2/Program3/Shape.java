public abstract class Shape {
    protected String color;

    public abstract double calculateArea();

    public void displayInfo() {
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("---------------------------");
    }
}