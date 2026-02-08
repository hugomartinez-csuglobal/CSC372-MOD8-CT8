import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            displayMenu();

            try {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        handleAddBook(scanner, inventory);
                        break;
                    case 2:
                        handleBorrowBook(scanner, inventory);
                        break;
                    case 3:
                        handleReturnBook(scanner, inventory);
                        break;
                    case 4:
                        handleSearchByTitle(scanner, inventory);
                        break;
                    case 5:
                        inventory.printAllBooks();
                        break;
                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 6.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }

            System.out.println(); // spacing between menu cycles
        }

        scanner.close();
    }

    // -------- Menu Display --------

    private static void displayMenu() {
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Search by Title");
        System.out.println("5. Print All Books");
        System.out.println("6. Exit");
    }

    // -------- Menu Handlers --------

    private static void handleAddBook(Scanner scanner, Inventory inventory) {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter number of pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(id, title, author, isbn, pages);
        inventory.addBook(book);
    }

    private static void handleBorrowBook(Scanner scanner, Inventory inventory) {
        System.out.print("Enter the ID of the book to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        inventory.borrowBook(bookId);
    }

    private static void handleReturnBook(Scanner scanner, Inventory inventory) {
        System.out.print("Enter the ID of the book to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        inventory.returnBook(bookId);
    }

    private static void handleSearchByTitle(Scanner scanner, Inventory inventory) {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();

        inventory.searchByTitle(title);
    }
}
