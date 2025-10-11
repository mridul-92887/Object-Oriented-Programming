import java.util.Scanner;

// Class representing a single book in the shop
class Product {
    // Data members (attributes)
    String title;
    String author;
    int copiesAvailable;

    // Method to take input from user
    void inputDetails() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        title = input.nextLine();

        System.out.print("Enter Author Name: ");
        author = input.nextLine();

        System.out.print("Enter Number of Copies Available: ");
        copiesAvailable = input.nextInt();
    }

    // Method to display book details
    void displayBookDetails() {
        System.out.println("\n--- Book Details ---");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Copies Available: " + copiesAvailable);
    }
}

// Main class
public class lgy_14 {
    public static void main(String[] args) {
        // Creating one Product object
        Product book = new Product();

        // Taking input from user
        book.inputDetails();

        // Displaying full details of the book
        book.displayBookDetails();
    }
}
