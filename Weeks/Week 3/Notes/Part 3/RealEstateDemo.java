// Blueprint for a House
class House {
    // Properties every house will have
    private String address;
    private int bedrooms;
    private int bathrooms;
    private double sqft;
    private String color;

    // Constructor - how to build a house from the blueprint
    public House(String address, int bedrooms, int bathrooms, double sqft) {
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sqft = sqft;
        this.color = "White"; // Default color
    }

    // Behavior: Paint the house a new color
    public void paintHouse(String newColor) {
        this.color = newColor;
        System.out.println("House painted " + newColor);
    }

    // Behavior: Display house details
    public void displayDetails() {
        System.out.println("House at " + address);
        System.out.println("Bedrooms: " + bedrooms + ", Bathrooms: " + bathrooms);
        System.out.println("Size: " + sqft + " sqft, Color: " + color);
        System.out.println("---------------------------");
    }
}

// Creating actual houses (objects) from the blueprint (class)
public class RealEstateDemo {
    public static void main(String[] args) {
        System.out.println("=== Real Estate Listings ===\n");

        // Each object is a unique house built from the same blueprint
        House house1 = new House("123 Oak St", 3, 2, 1500.0);
        House house2 = new House("456 Pine Ave", 4, 3, 2200.0);
        House house3 = new House("789 Elm Dr", 2, 1, 900.0);

        // Each house can be customized independently
        house1.paintHouse("Blue");
        house2.paintHouse("Green");
        house3.paintHouse("Yellow");

        // Each house maintains its own state
        house1.displayDetails();
        house2.displayDetails();
        house3.displayDetails();
    }
}