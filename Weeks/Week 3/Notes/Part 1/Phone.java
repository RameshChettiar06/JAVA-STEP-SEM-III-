// File: Phone.java
public class Phone {
    // ========== PROPERTIES (Attributes) ==========
    // What every phone has
    String brand;
    String model;
    String color;
    int batteryLevel;

    // ========== CONSTRUCTOR ==========
    // How to create a new phone
    public Phone(String phoneBrand, String phoneModel, String phoneColor) {
        brand = phoneBrand;
        model = phoneModel;
        color = phoneColor;
        batteryLevel = 100; // New phone comes fully charged
        System.out.println(" New " + brand + " " + model + " created!");
    }

    // ========== METHODS (Behaviors) ==========
    // What every phone can do
    public void makeCall(String number) {
        if (batteryLevel > 5) {
            batteryLevel -= 5;
            System.out.println(" Calling " + number + "...");
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println("Battery too low to make call!");
        }
    }

    public void sendMessage(String message) {
        if (batteryLevel > 2) {
            batteryLevel -= 2;
            System.out.println(" Message sent: " + message);
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println("Battery too low to send message!");
        }
    }

    public void playMusic() {
        if (batteryLevel > 10) {
            batteryLevel -= 10;
            System.out.println("Playing music...");
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println("Battery too low to play music!");
        }
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println("Phone fully charged! Battery: 100%");
    }

    public void showPhoneInfo() {
        System.out.println("=== Phone Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Battery: " + batteryLevel + "%");
    }

    // ========== MAIN METHOD ==========
    // Entry point to test the Phone class
    public static void main(String[] args) {
        // Create a new phone
        Phone myPhone = new Phone("Samsung", "Galaxy S21", "Phantom Black");

        // Show phone info
        myPhone.showPhoneInfo();

        // Make a call
        myPhone.makeCall("9876543210");

        // Send a message
        myPhone.sendMessage("Hello, how are you?");

        // Play music
        myPhone.playMusic();

        // Try to drain battery
        for (int i = 0; i < 10; i++) {
            myPhone.sendMessage("Ping " + i);
        }

        // Recharge
        myPhone.chargeBattery();

        // Final info
        myPhone.showPhoneInfo();
    }
}