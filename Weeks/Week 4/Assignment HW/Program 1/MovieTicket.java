public class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;

    // Default constructor → assigns "Unknown" movie
    public MovieTicket() {
        this("Unknown", "Unknown Theatre", 0, 0);
    }

    // Constructor with movie name → assigns default price = 200
    public MovieTicket(String movieName) {
        this(movieName, "Default Theatre", 0, 200);
    }

    // Constructor with movie name and seat number → assigns default theatre "PVR"
    public MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200);
    }

    // Full constructor → sets all details
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to display ticket details
    public void printTicket() {
        System.out.println("----------- Movie Ticket -----------");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
        System.out.println("-----------------------------------");
    }
}
