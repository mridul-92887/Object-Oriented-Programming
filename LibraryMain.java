import java.util.Scanner;

// Book class
class Book {
    int bookID;
    String title;
    String author;
    int quantity;
    double price;

    Book(int id, String t, String a, int q, double p) {
        bookID = id;
        title = t;
        author = a;
        quantity = q;
        price = p;
    }
    void displayBook() {
        System.out.println("ID: " + bookID + ", Title: " + title + ", Author: " + author +
                           ", Quantity: " + quantity + ", Price: $" + price);
    }
}

// Library class
class Library {
    Book[] books;
    int totalBooks;
    double totalFund;

    Library(int size) {
        books = new Book[size];
        totalBooks = 0;
        totalFund = 0;
    }

    // Add book
    void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        books[totalBooks] = new Book(id, title, author, qty, price);
        totalBooks++;
        totalFund += (qty * price);

        System.out.println("Book added successfully!");
    }

    // Display all books
    void displayAllBooks() {
        if (totalBooks == 0) {
            System.out.println("No books available!");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (int i = 0; i < totalBooks; i++) {
            books[i].displayBook();
        }
    }

    // Search book
    void searchBook(Scanner sc) {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].bookID == id) {
                System.out.println("Book Found:");
                books[i].displayBook();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Delete book
    void deleteBook(Scanner sc) {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].bookID == id) {
                totalFund -= (books[i].quantity * books[i].price);
                for (int j = i; j < totalBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                totalBooks--;
                found = true;
                System.out.println("Book deleted successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Issue book
    void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].bookID == id) {
                if (books[i].quantity > 0) {
                    books[i].quantity--;
                    totalFund -= books[i].price;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book not available!");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Show total books and fund
    void totalStatus() {
        int sumQuantity = 0;
        for (int i = 0; i < totalBooks; i++) {
            sumQuantity += books[i].quantity;
        }
        System.out.println("Total Books: " + sumQuantity);
        System.out.println("Total Fund: $" + totalFund);
    }
}

// Main class
public class LibraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library(100); // maximum 100 books

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Issue Book");
            System.out.println("6. Total Books and Fund");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: lib.addBook(sc); break;
                case 2: lib.displayAllBooks(); break;
                case 3: lib.searchBook(sc); break;
                case 4: lib.deleteBook(sc); break;
                case 5: lib.issueBook(sc); break;
                case 6: lib.totalStatus(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
