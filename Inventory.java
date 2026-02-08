import java.util.ArrayList;

public class Inventory {

    // Main inventory (available books)
    private ArrayList<Book> mainInventory;

    // Borrowed books
    private ArrayList<Book> borrowedInventory;

    // Constructor
    public Inventory() {
        mainInventory = new ArrayList<>();
        borrowedInventory = new ArrayList<>();
    }

    /**
     * Adds a book to the main inventory.
     */
    public void addBook(Book book) {
        mainInventory.add(book);
        System.out.println("Book added to the library.");
    }

    /**
     * Borrows a book by ID.
     */
    public void borrowBook(int bookId) {
        Book book = findBookById(mainInventory, bookId);

        if (book != null) {
            mainInventory.remove(book);
            borrowedInventory.add(book);
            System.out.println("Book successfully borrowed.");
        } else {
            System.out.println("Book not found or already borrowed.");
        }
    }

    /**
     * Returns a borrowed book by ID.
     */
    public void returnBook(int bookId) {
        Book book = findBookById(borrowedInventory, bookId);

        if (book != null) {
            borrowedInventory.remove(book);
            mainInventory.add(book);
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Book not found in borrowed inventory.");
        }
    }

    /**
     * Prints all books in the main inventory.
     */
    public void printAllBooks() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        for (Book book : mainInventory) {
            book.printBookInfo();
        }
    }

    /**
     * Searches for books by title (partial and case-insensitive).
     */
    public void searchByTitle(String title) {
        boolean found = false;

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.printBookInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // -------- Helper Methods --------

    /**
     * Finds a book by ID in a given list.
     */
    private Book findBookById(ArrayList<Book> list, int bookId) {
        for (Book book : list) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    /**
     * Returns the number of available books.
     */
    public int getMainInventoryCount() {
        return mainInventory.size();
    }

    /**
     * Returns the number of borrowed books.
     */
    public int getBorrowedInventoryCount() {
        return borrowedInventory.size();
    }
}
