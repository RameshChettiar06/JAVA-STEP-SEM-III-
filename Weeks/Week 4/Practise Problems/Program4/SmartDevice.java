public class SmartDevice {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // Constructor with parameter names matching field names
    public SmartDevice(String deviceName, String location,
                      boolean isOnline, double powerConsumption) {
        // Use this keyword to distinguish between parameters and fields
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;
        // Initialize connectedDevices array (size 5)
        this.connectedDevices = new String[5];
        // Set connectionCount to 0
        this.connectionCount = 0;
    }

    // Method using this for parameter disambiguation
    public void updateLocation(String location) {
        this.location = location; // Use this.location to assign parameter value
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption; // Use this keyword when parameter name matches field
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // Method returning this for chaining
    public SmartDevice setOnline(boolean isOnline) {
        this.isOnline = isOnline; // Use this keyword and return this for method chaining
        return this;
    }

    public SmartDevice connectToDevice(String deviceName) {
        // Add device to connectedDevices array
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        }
        return this; // Enable method chaining
    }

    public SmartDevice rename(String deviceName) {
        // Use this keyword for disambiguation
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    public void displayDeviceInfo() {
        // Use this keyword to access instance variables
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

    // Method that calls other methods using this
    public void performInitialSetup() {
        // Use this to call other methods
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");

        // Create devices with parameter names matching field names
        SmartDevice device1 = new SmartDevice("Smart Bulb", "Living Room", false, 9.5);
        SmartDevice device2 = new SmartDevice("Thermostat", "Hallway", true, 3.2);

        // Demonstrate this keyword in various contexts
        device1.displayDeviceInfo();
        device1.updateLocation("Bedroom");
        device1.updatePowerConsumption(10.0);

        // Test method chaining using returned this
        device1.setOnline(true)
               .connectToDevice("Alexa")
               .rename("Bedroom Bulb")
               .connectToDevice("Smart Speaker");

        device1.displayDeviceInfo();

        // Show parameter disambiguation scenarios
        device2.updateLocation("Kitchen");
        device2.updatePowerConsumption(4.0);

        device2.performInitialSetup();
        device2.connectToDevice("Smart Bulb")
               .connectToDevice("Smart TV");

        device2.displayDeviceInfo();

        // Example of method chaining:
        SmartDevice device3 = new SmartDevice("Hub", "Kitchen", false, 5.0);
        device3.setOnline(true)
               .connectToDevice("Alexa")
               .rename("Kitchen Hub");
        device3.displayDeviceInfo();
    }
}