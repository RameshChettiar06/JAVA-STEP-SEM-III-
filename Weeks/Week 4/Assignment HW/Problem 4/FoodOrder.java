public class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;

    private static final double FIXED_RATE = 150.0; // Default price per item

    // Default constructor → Unknown order
    public FoodOrder() {
        this("Unknown", "Unknown Food", 0, 0);
    }

    // Constructor with food item → quantity = 1, default price
    public FoodOrder(String foodItem) {
        this("Anonymous", foodItem, 1, FIXED_RATE);
    }

    // Constructor with food item and quantity → calculates price = quantity × fixedRate
    public FoodOrder(String foodItem, int quantity) {
        this("Anonymous", foodItem, quantity, quantity * FIXED_RATE);
    }

    // Full constructor
    public FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    // Print bill
    public void printBill() {
        System.out.println("----------- Food Order Bill -----------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: $" + price);
        System.out.println("--------------------------------------");
    }
}
