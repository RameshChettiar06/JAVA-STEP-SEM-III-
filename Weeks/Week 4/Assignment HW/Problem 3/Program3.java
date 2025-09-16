public class Program3 {
    public static void main(String[] args) {
        // Creating books using different constructors
        Book book1 = new Book();
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", "1234567890", true);

        // Borrowing and returning books
        book2.borrowBook();
        book3.borrowBook();
        book3.borrowBook(); // Already borrowed
        book2.returnBook();
        book2.returnBook(); // Already returned

        // Displaying book information
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
    }
}
