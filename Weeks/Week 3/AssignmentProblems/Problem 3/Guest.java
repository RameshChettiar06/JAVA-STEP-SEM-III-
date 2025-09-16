class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory;
    private int bookingCount;

    // Constructor
    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[10]; // Max 10 bookings in history
        this.bookingCount = 0;
    }

    // Getter methods
    public String getGuestId() { return guestId; }
    public String getGuestName() { return guestName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String[] getBookingHistory() { return bookingHistory; }
    public int getBookingCount() { return bookingCount; }

    // Setter methods
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    // Add booking to history
    public void addBookingToHistory(String bookingId) {
        if (bookingCount < bookingHistory.length) {
            bookingHistory[bookingCount] = bookingId;
            bookingCount++;
        } else {
            System.out.println("Booking history is full for guest: " + guestName);
        }
    }

    // Remove booking from history
    public void removeBookingFromHistory(String bookingId) {
        for (int i = 0; i < bookingCount; i++) {
            if (bookingHistory[i].equals(bookingId)) {
                // Shift elements to fill the gap
                for (int j = i; j < bookingCount - 1; j++) {
                    bookingHistory[j] = bookingHistory[j + 1];
                }
                bookingHistory[bookingCount - 1] = null;
                bookingCount--;
                break;
            }
        }
    }

    // Display guest information
    public void displayGuestInfo() {
        System.out.println("Guest ID: " + guestId);
        System.out.println("Name: " + guestName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.print("Booking History: ");
        if (bookingCount == 0) {
            System.out.println("No bookings");
        } else {
            for (int i = 0; i < bookingCount; i++) {
                System.out.print(bookingHistory[i]);
                if (i < bookingCount - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId='" + guestId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}