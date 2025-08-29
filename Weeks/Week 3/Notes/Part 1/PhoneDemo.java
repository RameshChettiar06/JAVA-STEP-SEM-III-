// File: PhoneDemo.java
public class PhoneDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Different Phones ===\n");

        // Creating objects from the Phone class
        Phone iPhone = new Phone("Apple", "iPhone 15", "Black");
        Phone samsung = new Phone("Samsung", "Galaxy S24", "Blue");
        Phone pixel = new Phone("Google", "Pixel 8", "White");

        System.out.println("\n=== Phone Information ===");
        iPhone.showPhoneInfo();
        samsung.showPhoneInfo();
        pixel.showPhoneInfo();

        System.out.println("\n=== Using iPhone ===");
        iPhone.makeCall("123-456-7890");
        iPhone.sendMessage("Hello World!");
        iPhone.playMusic();
        iPhone.playMusic(); // Uses more battery

        // Overloaded call with duration
        System.out.println("\n Timed Call from iPhone:");
        iPhone.makeCall("555-000-1111", 10); // 10-minute call

        System.out.println("\n=== Using Samsung ===");
        samsung.sendMessage("Hi from Samsung!");
        samsung.makeCall("987-654-3210");

        // Conditional charging
        if (samsung.batteryLevel < 50) {
            System.out.println("\n🔌 Samsung battery low. Charging...");
            samsung.chargeBattery();
        }

        System.out.println("\n=== Draining Pixel Battery ===");
        while (pixel.batteryLevel > 10) {
            pixel.playMusic();
        }

        System.out.println("\n=== Charging iPhone ===");
        iPhone.chargeBattery();
        iPhone.showPhoneInfo();

        System.out.println("\n=== Final Status ===");
        iPhone.showPhoneInfo();
        samsung.showPhoneInfo();
        pixel.showPhoneInfo();
    }
}

// ========== Phone CLASS ==========
class Phone {
    // ========== PROPERTIES (Attributes) ==========
    String brand;
    String model;
    String color;
    int batteryLevel;

    // ========== CONSTRUCTOR ==========
    public Phone(String phoneBrand, String phoneModel, String phoneColor) {
        brand = phoneBrand;
        model = phoneModel;
        color = phoneColor;
        batteryLevel = 100; // New phone comes fully charged
        System.out.println(" New " + brand + " " + model + " created!");
    }

    // ========== METHODS (Behaviors) ==========
    public void makeCall(String number) {
        if (batteryLevel > 5) {
            batteryLevel -= 5;
            System.out.println(" Calling " + number + "...");
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println(" Battery too low to make call!");
        }
    }

    // Overloaded method: make call with duration
    public void makeCall(String number, int durationMinutes) {
        int drain = durationMinutes * 2;
        if (batteryLevel > drain) {
            batteryLevel -= drain;
            System.out.println(" Calling " + number + " for " + durationMinutes + " minutes...");
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println(" Not enough battery for a " + durationMinutes + "-minute call!");
        }
    }

    public void sendMessage(String message) {
        if (batteryLevel > 2) {
            batteryLevel -= 2;
            System.out.println(" Message sent: " + message);
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println(" Battery too low to send message!");
        }
    }

    public void playMusic() {
        if (batteryLevel > 10) {
            batteryLevel -= 10;
            System.out.println(" Playing music...");
            System.out.println("Battery: " + batteryLevel + "%");
        } else {
            System.out.println(" Battery too low to play music!");
        }
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(" Phone fully charged! Battery: 100%");
    }

    public void showPhoneInfo() {
        System.out.println(" === Phone Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Battery: " + batteryLevel + "%");
    }
}