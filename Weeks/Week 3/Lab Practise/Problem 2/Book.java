/*a. Create a Book class with private variables: bookId (String), title (String), author
(String), isAvailable (boolean), and static variables totalBooks (int),
availableBooks (int)
b. Create a constructor for Book class and methods: issueBook(), returnBook(),
displayBookInfo()
*/
public class Book{
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    static int totalBooks = 0;
    static int availableBooks = 0;

    // Constructor for Book class
    public Book(String title, String author) {
        this.bookId = generateBookId();
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    // Method to issue a book
    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        } else {
            System.out.println("Book is not available for issue.");
            return false;
        }
    }

    // Method to return a book
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        } else {
            System.out.println("Book was not issued.");
        }
    }

    // Method to display book information
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    // Static method to generate unique book ID
    private static int bookCounter = 0;
    public static String generateBookId() {
        bookCounter++;
        return "BOOK" + String.format("%03d", bookCounter);
    }
}
/*c. Create a Member class with private variables: memberId (String), memberName
(String), booksIssued (String array to store book IDs), bookCount (int to track number
of books issued)
d. Create methods in Member class: borrowBook(Book book) which checks if book
is available and updates both book and member status, returnBook(String
bookId, Book[] books) to return a specific book
e. Create static methods in both classes to generate unique IDs and track statistics
  */
public class Member{
    private String memberID;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;

    public Member(String memberName) {
        this.memberID = generateMemberId();
        this.memberName = memberName;
        this.booksIssued = new String[5]; // Assuming a member can issue up to 5 books
        this.bookCount = 0;
    }

    // Method to borrow a book
    public boolean borrowBook(Book book) {
        if (book.issueBook()) {
            if (bookCount < booksIssued.length) {
                booksIssued[bookCount] = book.getBookId();
                bookCount++;
                return true;
            } else {
                System.out.println("Cannot borrow more books.");
                book.returnBook();
                return false;
            }
        }
        return false;
    }

    // Method to return a book
    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                booksIssued[i] = null;
                bookCount--;
                for (int j = i; j < bookCount; j++) {
                    booksIssued[j] = booksIssued[j + 1];
                }
                booksIssued[bookCount] = null;
                // Find the book in the books array and return it
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        break;
                    }
                }
                return;
            }
        }
        System.out.println("Book not found in issued books.");
    }

    // Static method to generate unique member ID
    private static int memberCounter = 0;
    public static String generateMemberId() {
        memberCounter++;
        return "MEMBER" + String.format("%03d", memberCounter);
    }

    /*f. In main, create arrays of Book and Member objects, demonstrate borrowing and
    returning books, showing how objects interact with each other */
    public static void main(String args[]){
        Book books[] = new Book[3];
        books[0] = new Book("Mehula", "Amish Tripathi");
        books[1] = new Book("Stream of Life", "Rabindranath Tagore");
        books[2] = new Book("A Suitable Boy", "Vikram Seth");

        Member members[] = new Member[2];
        members[0] = new Member("Ananya");
        members[1] = new Member("Bolly");

        // Demonstrate borrowing books
        members[0].borrowBook(books[0]);
        members[1].borrowBook(books[1]);

        // Show book and member information
        for (Book book : books) {
            book.displayBookInfo();
        }

        for (Member member : members) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Member Name: " + member.getMemberName());
        }

        // Demonstrate returning books
        members[0].returnBook(books[0].getBookId(), books);
        members[1].returnBook(books[1].getBookId(), books);
    }
}