import java.util.Scanner;
class Book {
    int bookID;
    String title;
    String author;
    int quantity;
    double price;

    // Constructor
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

public class LibrarySystem {
    static Scanner sc = new Scanner(System.in);
    static Book[] books = new Book[100]; // maximum 100 books
    static int totalBooks = 0;           // total number of book objects
    static double totalFund = 0;         // total fund in library

    public static void main(String[] args) {
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
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayAllBooks(); break;
                case 3: searchBook(); break;
                case 4: deleteBook(); break;
                case 5: issueBook(); break;
                case 6: totalStatus(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }

    // Add new book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        books[totalBooks] = new Book(id, title, author, quantity, price);
        totalBooks++;
        totalFund += (quantity * price);

        System.out.println("Book added successfully!");
    }

    // Display all books
    static void displayAllBooks() {
        if (totalBooks == 0) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\n--- All Books ---");
        for (int i = 0; i < totalBooks; i++) {
            books[i].displayBook();
        }
    }

    // Search book by ID
    static void searchBook() {
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

    // Delete book by ID
    static void deleteBook() {
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

    // Issue book to student
    static void issueBook() {
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

    // Total books and fund
    static void totalStatus() {
        int sumQuantity = 0;
        for (int i = 0; i < totalBooks; i++) {
            sumQuantity += books[i].quantity;
        }

        System.out.println("Total Books: " + sumQuantity);
        System.out.println("Total Fund: $" + totalFund);
    }
}
