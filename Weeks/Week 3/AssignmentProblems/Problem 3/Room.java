/*
 * Build a hotel reservation management system handling rooms, guests,
and bookings.
Create a Room class with attributes: roomNumber (String), roomType (String),
pricePerNight (double), isAvailable (boolean), maxOccupancy (int)
● Create a Guest class with attributes: guestId (String), guestName (String),
phoneNumber (String), email (String), bookingHistory (String array)
● Create a Booking class with attributes: bookingId (String), guest (Guest object),
room (Room object), checkInDate (String), checkOutDate (String), totalAmount
(double)
● Include static variables: totalBookings (int), hotelRevenue (double), hotelName
(String)
● Implement reservation management methods: makeReservation(),
cancelReservation(), checkAvailability(), calculateBill()
● Create static methods for reporting: getOccupancyRate(), getTotalRevenue(),
getMostPopularRoomType()
● Implement a complete booking workflow from room search to checkout
 */

class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    // Constructor
    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.maxOccupancy = maxOccupancy;
        this.isAvailable = true; // Initially available
    }

    // Getter methods
    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public int getMaxOccupancy() { return maxOccupancy; }

    // Setter methods
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    // Display room information
    public void displayRoomInfo() {
        System.out.println("Room " + roomNumber + " | Type: " + roomType + 
                          " | Price: $" + pricePerNight + "/night | Max Occupancy: " + maxOccupancy + 
                          " | Available: " + (isAvailable ? "Yes" : "No"));
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", isAvailable=" + isAvailable +
                ", maxOccupancy=" + maxOccupancy +
                '}';
    }
}