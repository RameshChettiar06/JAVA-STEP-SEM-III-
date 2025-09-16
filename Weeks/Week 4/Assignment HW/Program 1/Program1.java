public class Program1 {
    public static void main(String[] args) {
        // Creating tickets using different constructors
        MovieTicket ticket1 = new MovieTicket();
        MovieTicket ticket2 = new MovieTicket("Avatar 2");
        MovieTicket ticket3 = new MovieTicket("Top Gun: Maverick", 15);
        MovieTicket ticket4 = new MovieTicket("Guardians of the Galaxy", "IMAX", 20, 350);

        // Printing tickets
        ticket1.printTicket();
        ticket2.printTicket();
        ticket3.printTicket();
        ticket4.printTicket();
    }
}
