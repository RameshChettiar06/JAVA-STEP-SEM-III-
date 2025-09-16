class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    // Static variables
    private static int totalBookings = 0;
    private static double hotelRevenue = 0.0;
    private static String hotelName = "Grand Palace Hotel";
    private static int bookingCounter = 0;

    // Constructor
    public Booking(Guest guest, Room room, String checkInDate, String checkOutDate, int nights) {
        this.bookingId = generateBookingId();
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateBill(nights);
        totalBookings++;
        hotelRevenue += totalAmount;
        
        // Update guest's booking history
        guest.addBookingToHistory(bookingId);
        
        // Mark room as unavailable
        room.setAvailable(false);
    }

    // Generate unique booking ID
    private static String generateBookingId() {
        bookingCounter++;
        return "BK" + String.format("%04d", bookingCounter);
    }

    // Calculate bill based on nights and room price
    public double calculateBill(int nights) {
        return nights * room.getPricePerNight();
    }

    // Getter methods
    public String getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public double getTotalAmount() { return totalAmount; }

    // Static getter methods
    public static int getTotalBookings() { return totalBookings; }
    public static double getHotelRevenue() { return hotelRevenue; }
    public static String getHotelName() { return hotelName; }

    // Static setter method
    public static void setHotelName(String name) { hotelName = name; }

    // Cancel booking
    public void cancelBooking() {
        // Make room available again
        room.setAvailable(true);
        
        // Remove from guest's history
        guest.removeBookingFromHistory(bookingId);
        
        // Update statistics
        totalBookings--;
        hotelRevenue -= totalAmount;
        
        System.out.println("Booking " + bookingId + " has been cancelled successfully.");
    }

    // Display booking information
    public void displayBookingInfo() {
        System.out.println("\n--- BOOKING DETAILS ---");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getGuestName());
        System.out.println("Room: " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Hotel: " + hotelName);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", guest=" + guest.getGuestName() +
                ", room=" + room.getRoomNumber() +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}