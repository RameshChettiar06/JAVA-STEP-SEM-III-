public class Program4 {
    public static void main(String[] args) {
        // Creating orders using different constructors
        FoodOrder order1 = new FoodOrder();
        FoodOrder order2 = new FoodOrder("Pizza");
        FoodOrder order3 = new FoodOrder("Burger", 3);
        FoodOrder order4 = new FoodOrder("Alice", "Pasta", 2, 300.0);

        // Printing bills
        order1.printBill();
        order2.printBill();
        order3.printBill();
        order4.printBill();
    }
}
