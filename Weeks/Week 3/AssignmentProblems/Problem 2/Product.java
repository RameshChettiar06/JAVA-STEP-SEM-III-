/*Develop an online shopping cart system that manages products and
customer purchases.

Create a Product class with attributes: productId (String), productName (String),
price (double), category (String), stockQuantity (int)
● Create a ShoppingCart class with attributes: cartId (String), customerName
(String), products (Product array), quantities (int array), cartTotal (double)
● Include static variables in Product class: totalProducts (int), categories (String
array)
● Implement methods in ShoppingCart: addProduct(Product product, int
quantity), removeProduct(String productId), calculateTotal(),
displayCart(), checkout()
● Create static methods in Product class: findProductById(Product[] products,
String productId), getProductsByCategory(Product[] products,
String category)
● Create a menu-driven system allowing users to browse products, add/remove items from
cart, and checkout
● Demonstrate object interaction */

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    // Static variables
    private static int totalProducts = 0;
    private static String[] categories = {"Electronics", "Clothing", "Books", "Home", "Sports"};

    // Constructor
    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    // Getter methods
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    // Setter for stock quantity
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Static method to find product by ID
    public static Product findProductById(Product[] products, String productId) {
        for (Product product : products) {
            if (product != null && product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Static method to get products by category
    public static Product[] getProductsByCategory(Product[] products, String category) {
        Product[] result = new Product[products.length];
        int count = 0;
        for (Product product : products) {
            if (product != null && product.getCategory().equalsIgnoreCase(category)) {
                result[count++] = product;
            }
        }
        return result;
    }

    // Static getter methods
    public static int getTotalProducts() { return totalProducts; }
    public static String[] getCategories() { return categories; }

    // Display product info
    public void displayProduct() {
        System.out.println("ID: " + productId + " | Name: " + productName + 
                          " | Price: $" + price + " | Category: " + category + 
                          " | Stock: " + stockQuantity);
    }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;

    // Constructor
    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[10]; // Max 10 different products
        this.quantities = new int[10];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

    // Add product to cart
    public boolean addProduct(Product product, int quantity) {
        if (product.getStockQuantity() < quantity) {
            System.out.println("Insufficient stock! Available: " + product.getStockQuantity());
            return false;
        }

        // Check if product already exists in cart
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(product.getProductId())) {
                quantities[i] += quantity;
                product.setStockQuantity(product.getStockQuantity() - quantity);
                calculateTotal();
                System.out.println("Updated quantity for " + product.getProductName());
                return true;
            }
        }

        // Add new product
        if (itemCount < products.length) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            product.setStockQuantity(product.getStockQuantity() - quantity);
            itemCount++;
            calculateTotal();
            System.out.println("Added " + product.getProductName() + " to cart");
            return true;
        } else {
            System.out.println("Cart is full!");
            return false;
        }
    }

    // Remove product from cart
    public boolean removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                // Return stock
                products[i].setStockQuantity(products[i].getStockQuantity() + quantities[i]);
                
                // Shift elements
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                itemCount--;
                calculateTotal();
                System.out.println("Product removed from cart");
                return true;
            }
        }
        System.out.println("Product not found in cart");
        return false;
    }

    // Calculate total
    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }

    // Display cart
    public void displayCart() {
        System.out.println("\n--- Shopping Cart for " + customerName + " ---");
        System.out.println("Cart ID: " + cartId);
        if (itemCount == 0) {
            System.out.println("Cart is empty");
            return;
        }

        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + products[i].getProductName() + 
                              " | Price: $" + products[i].getPrice() + 
                              " | Quantity: " + quantities[i] + 
                              " | Subtotal: $" + (products[i].getPrice() * quantities[i]));
        }
        System.out.println("Total: $" + cartTotal);
    }

    // Checkout
    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cart is empty. Cannot checkout.");
            return;
        }

        System.out.println("\n--- CHECKOUT ---");
        displayCart();
        System.out.println("Thank you for your purchase, " + customerName + "!");
        System.out.println("Total amount: $" + cartTotal);
        
        // Clear cart after checkout
        itemCount = 0;
        cartTotal = 0.0;
    }

    // Getter methods
    public String getCartId() { return cartId; }
    public String getCustomerName() { return customerName; }
    public double getCartTotal() { return cartTotal; }
    public int getItemCount() { return itemCount; }
}