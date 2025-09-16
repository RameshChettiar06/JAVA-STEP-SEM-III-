import java.util.Scanner;

public class HotelReservationSystem {
    private static Room[] rooms;
    private static Guest[] guests;
    private static Booking[] bookings;
    private static int guestCount = 0;
    private static int bookingCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize hotel
        initializeHotel();
        
        // Welcome message
        System.out.println("=== WELCOME TO " + Booking.getHotelName().toUpperCase() + " ===");
        
        // Main menu loop
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    checkAvailability();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    generateReports();
                    break;
                case 6:
                    manageGuests();
                    break;
                case 7:
                    checkoutWorkflow();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using " + Booking.getHotelName() + " Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeHotel() {
        // Initialize rooms array
        rooms = new Room[20];
        rooms[0] = new Room("101", "Single", 100.0, 1);
        rooms[1] = new Room("102", "Single", 100.0, 1);
        rooms[2] = new Room("103", "Single", 100.0, 1);
        rooms[3] = new Room("201", "Double", 150.0, 2);
        rooms[4] = new Room("202", "Double", 150.0, 2);
        rooms[5] = new Room("203", "Double", 150.0, 2);
        rooms[6] = new Room("301", "Suite", 300.0, 4);
        rooms[7] = new Room("302", "Suite", 300.0, 4);
        rooms[8] = new Room("401", "Deluxe", 250.0, 3);
        rooms[9] = new Room("402", "Deluxe", 250.0, 3);
        rooms[10] = new Room("104", "Single", 100.0, 1);
        rooms[11] = new Room("105", "Single", 100.0, 1);
        rooms[12] = new Room("204", "Double", 150.0, 2);
        rooms[13] = new Room("205", "Double", 150.0, 2);
        rooms[14] = new Room("303", "Suite", 300.0, 4);
        rooms[15] = new Room("403", "Deluxe", 250.0, 3);

        // Initialize other arrays
        guests = new Guest[100];
        bookings = new Booking[100];
    }

    private static void displayMainMenu() {
        System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
        System.out.println("1. Check Room Availability");
        System.out.println("2. Make Reservation");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. View All Bookings");
        System.out.println("5. Generate Reports");
        System.out.println("6. Manage Guests");
        System.out.println("7. Checkout Process");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void checkAvailability() {
        System.out.println("\n=== ROOM AVAILABILITY ===");
        System.out.println("Available Rooms:");
        boolean foundAvailable = false;
        
        for (Room room : rooms) {
            if (room != null && room.isAvailable()) {
                room.displayRoomInfo();
                foundAvailable = true;
            }
        }
        
        if (!foundAvailable) {
            System.out.println("No rooms currently available.");
        }
        
        // Show rooms by type
        System.out.println("\n--- ROOMS BY TYPE ---");
        String[] roomTypes = {"Single", "Double", "Suite", "Deluxe"};
        for (String type : roomTypes) {
            int available = 0;
            int total = 0;
            for (Room room : rooms) {
                if (room != null && room.getRoomType().equals(type)) {
                    total++;
                    if (room.isAvailable()) available++;
                }
            }
            System.out.println(type + ": " + available + "/" + total + " available");
        }
    }

    private static void makeReservation() {
        System.out.println("\n=== MAKE RESERVATION ===");
        
        // First check if there are available rooms
        boolean hasAvailableRooms = false;
        for (Room room : rooms) {
            if (room != null && room.isAvailable()) {
                hasAvailableRooms = true;
                break;
            }
        }
        
        if (!hasAvailableRooms) {
            System.out.println("Sorry, no rooms are currently available.");
            return;
        }
        
        // Get guest information
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        // Create or find guest
        Guest guest = findOrCreateGuest(guestName, phoneNumber, email);
        
        // Show available rooms
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room != null && room.isAvailable()) {
                room.displayRoomInfo();
            }
        }
        
        // Get room choice
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();
        Room selectedRoom = findRoomByNumber(roomNumber);
        
        if (selectedRoom == null || !selectedRoom.isAvailable()) {
            System.out.println("Room not available or doesn't exist.");
            return;
        }
        
        // Get booking details
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();
        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create booking
        Booking booking = new Booking(guest, selectedRoom, checkInDate, checkOutDate, nights);
        bookings[bookingCount++] = booking;
        
        booking.displayBookingInfo();
        System.out.println("Reservation made successfully!");
    }

    private static void cancelReservation() {
        System.out.println("\n=== CANCEL RESERVATION ===");
        System.out.print("Enter booking ID: ");
        String bookingId = scanner.nextLine();
        
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.cancelBooking();
            // Remove from bookings array
            removeBookingFromArray(bookingId);
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static void viewBookings() {
        System.out.println("\n=== ALL BOOKINGS ===");
        if (bookingCount == 0) {
            System.out.println("No bookings found.");
            return;
        }
        
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null) {
                bookings[i].displayBookingInfo();
                System.out.println();
            }
        }
    }

    private static void generateReports() {
        System.out.println("\n=== HOTEL REPORTS ===");
        System.out.println("Hotel: " + Booking.getHotelName());
        System.out.println("Total Bookings: " + Booking.getTotalBookings());
        System.out.println("Total Revenue: $" + Booking.getHotelRevenue());
        System.out.println("Occupancy Rate: " + getOccupancyRate() + "%");
        System.out.println("Most Popular Room Type: " + getMostPopularRoomType());
        
        // Room type statistics
        System.out.println("\n--- ROOM TYPE STATISTICS ---");
        String[] roomTypes = {"Single", "Double", "Suite", "Deluxe"};
        for (String type : roomTypes) {
            int total = 0, occupied = 0;
            for (Room room : rooms) {
                if (room != null && room.getRoomType().equals(type)) {
                    total++;
                    if (!room.isAvailable()) occupied++;
                }
            }
            System.out.println(type + " Rooms: " + occupied + "/" + total + " occupied");
        }
    }

    private static void manageGuests() {
        System.out.println("\n=== GUEST MANAGEMENT ===");
        System.out.println("1. View All Guests");
        System.out.println("2. Search Guest");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                viewAllGuests();
                break;
            case 2:
                searchGuest();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void checkoutWorkflow() {
        System.out.println("\n=== CHECKOUT PROCESS ===");
        System.out.print("Enter booking ID for checkout: ");
        String bookingId = scanner.nextLine();
        
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.displayBookingInfo();
            System.out.println("\nCheckout Summary:");
            System.out.println("Final Bill: $" + booking.getTotalAmount());
            System.out.println("Thank you for staying at " + Booking.getHotelName() + "!");
            
            // Make room available for new bookings
            booking.getRoom().setAvailable(true);
            System.out.println("Room " + booking.getRoom().getRoomNumber() + " is now available for new bookings.");
        } else {
            System.out.println("Booking not found.");
        }
    }

    // Helper methods
    private static Guest findOrCreateGuest(String name, String phone, String email) {
        // Check if guest already exists
        for (int i = 0; i < guestCount; i++) {
            if (guests[i] != null && guests[i].getGuestName().equalsIgnoreCase(name)) {
                return guests[i];
            }
        }
        
        // Create new guest
        String guestId = "G" + String.format("%03d", guestCount + 1);
        Guest newGuest = new Guest(guestId, name, phone, email);
        guests[guestCount++] = newGuest;
        return newGuest;
    }

    private static Room findRoomByNumber(String roomNumber) {
        for (Room room : rooms) {
            if (room != null && room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    private static Booking findBookingById(String bookingId) {
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null && bookings[i].getBookingId().equals(bookingId)) {
                return bookings[i];
            }
        }
        return null;
    }

    private static void removeBookingFromArray(String bookingId) {
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null && bookings[i].getBookingId().equals(bookingId)) {
                // Shift elements
                for (int j = i; j < bookingCount - 1; j++) {
                    bookings[j] = bookings[j + 1];
                }
                bookings[--bookingCount] = null;
                break;
            }
        }
    }

    private static double getOccupancyRate() {
        int totalRooms = 0;
        int occupiedRooms = 0;
        
        for (Room room : rooms) {
            if (room != null) {
                totalRooms++;
                if (!room.isAvailable()) {
                    occupiedRooms++;
                }
            }
        }
        
        return totalRooms > 0 ? (double) occupiedRooms / totalRooms * 100 : 0;
    }

    private static String getMostPopularRoomType() {
        String[] roomTypes = {"Single", "Double", "Suite", "Deluxe"};
        int[] typeCounts = new int[roomTypes.length];
        
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null) {
                String roomType = bookings[i].getRoom().getRoomType();
                for (int j = 0; j < roomTypes.length; j++) {
                    if (roomTypes[j].equals(roomType)) {
                        typeCounts[j]++;
                        break;
                    }
                }
            }
        }
        
        int maxIndex = 0;
        for (int i = 1; i < typeCounts.length; i++) {
            if (typeCounts[i] > typeCounts[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return roomTypes[maxIndex];
    }

    private static void viewAllGuests() {
        System.out.println("\n=== ALL GUESTS ===");
        if (guestCount == 0) {
            System.out.println("No guests registered.");
            return;
        }
        
        for (int i = 0; i < guestCount; i++) {
            if (guests[i] != null) {
                guests[i].displayGuestInfo();
                System.out.println();
            }
        }
    }

    private static void searchGuest() {
        System.out.print("Enter guest name to search: ");
        String searchName = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < guestCount; i++) {
            if (guests[i] != null && guests[i].getGuestName().toLowerCase().contains(searchName.toLowerCase())) {
                guests[i].displayGuestInfo();
                found = true;
                System.out.println();
            }
        }
        
        if (!found) {
            System.out.println("No guests found with that name.");
        }
    }
}