// ...existing code...
     class Rectangle {
    private double width;
    private double height;

    // Default constructor - creates unit square
    public Rectangle() {
        this(1.0, 1.0); // Calls parameterized constructor
    }

    // Square constructor - width equals height
    public Rectangle(double side) {
        this(side, side); // Calls two-parameter constructor
    }

    // Full rectangle constructor
    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive");
        }
        this.width = width;
        this.height = height;
    }

    // Copy constructor
    public Rectangle(Rectangle other) {
        if (other == null) {
            throw new IllegalArgumentException("Source rectangle cannot be null");
        }
        this.width = other.width;
        this.height = other.height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Width must be positive");
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be positive");
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[width=%.2f, height=%.2f]", width, height);
    }

    // Simple test driver
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();           // unit square
        Rectangle r2 = new Rectangle(3.0);        // square with side 3
        Rectangle r3 = new Rectangle(4.0, 5.0);   // 4x5 rectangle
        Rectangle r4 = new Rectangle(r3);         // copy of r3

        System.out.println(r1 + " area=" + r1.getArea() + " perim=" + r1.getPerimeter());
        System.out.println(r2 + " area=" + r2.getArea() + " perim=" + r2.getPerimeter());
        System.out.println(r3 + " area=" + r3.getArea() + " perim=" + r3.getPerimeter());
        System.out.println(r4 + " area=" + r4.getArea() + " perim=" + r4.getPerimeter());

        try {
            new Rectangle(0, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}