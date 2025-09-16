public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Default constructor → empty book
    public Book() {
        this("Unknown", "Unknown", "0000", true);
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this(title, author, "0000", true);
    }

    // Constructor with all details
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Borrow the book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    // Return the book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    // Display book information
    public void displayBookInfo() {
        System.out.println("----------- Book Info -----------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("--------------------------------");
    }
}
