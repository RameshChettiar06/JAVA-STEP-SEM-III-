import java.util.Scanner;

public class OnlineShoppingSystem {
    private static Product[] inventory;
    private static ShoppingCart cart;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize inventory
        initializeInventory();
        
        // Get customer details
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        cart = new ShoppingCart("CART001", customerName);

        // Menu-driven system
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    browseByCategory();
                    break;
                case 3:
                    addProductToCart();
                    break;
                case 4:
                    removeProductFromCart();
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeInventory() {
        inventory = new Product[15];
        inventory[0] = new Product("E001", "Laptop", 999.99, "Electronics", 10);
        inventory[1] = new Product("E002", "Smartphone", 599.99, "Electronics", 15);
        inventory[2] = new Product("E003", "Headphones", 199.99, "Electronics", 20);
        inventory[3] = new Product("C001", "T-Shirt", 29.99, "Clothing", 50);
        inventory[4] = new Product("C002", "Jeans", 79.99, "Clothing", 30);
        inventory[5] = new Product("C003", "Sneakers", 129.99, "Clothing", 25);
        inventory[6] = new Product("B001", "Java Programming", 49.99, "Books", 40);
        inventory[7] = new Product("B002", "Data Structures", 59.99, "Books", 35);
        inventory[8] = new Product("B003", "Algorithms", 69.99, "Books", 30);
        inventory[9] = new Product("H001", "Coffee Maker", 89.99, "Home", 12);
        inventory[10] = new Product("H002", "Microwave", 149.99, "Home", 8);
        inventory[11] = new Product("S001", "Basketball", 39.99, "Sports", 20);
        inventory[12] = new Product("S002", "Tennis Racket", 99.99, "Sports", 15);
        inventory[13] = new Product("S003", "Running Shoes", 119.99, "Sports", 18);
        inventory[14] = new Product("H003", "Blender", 79.99, "Home", 10);
    }

    private static void displayMenu() {
        System.out.println("\n--- ONLINE SHOPPING SYSTEM ---");
        System.out.println("1. Browse All Products");
        System.out.println("2. Browse by Category");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. Remove Product from Cart");
        System.out.println("5. View Cart");
        System.out.println("6. Checkout");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void browseProducts() {
        System.out.println("\n--- ALL PRODUCTS ---");
        for (Product product : inventory) {
            if (product != null) {
                product.displayProduct();
            }
        }
        System.out.println("Total Products: " + Product.getTotalProducts());
    }

    private static void browseByCategory() {
        System.out.println("\n--- CATEGORIES ---");
        String[] categories = Product.getCategories();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
        
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();
        
        Product[] categoryProducts = Product.getProductsByCategory(inventory, category);
        System.out.println("\n--- PRODUCTS IN " + category.toUpperCase() + " ---");
        boolean found = false;
        for (Product product : categoryProducts) {
            if (product != null) {
                product.displayProduct();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
    }

    private static void addProductToCart() {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = Product.findProductById(inventory, productId);
        if (product != null) {
            cart.addProduct(product, quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void removeProductFromCart() {
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine();
        cart.removeProduct(productId);
    }
}