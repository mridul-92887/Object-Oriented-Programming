import java.util.Scanner;

class Product {
    // Data Members
    String title;
    String author;
    int copiesAvailable;

    // Method to take user input
    void inputDetails() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter book title: ");
        title = input.nextLine();

        System.out.print("Enter author name: ");
        author = input.nextLine();

        System.out.print("Enter number of available copies: ");
        copiesAvailable = input.nextInt();
    }

    // Method to borrow book copies
    void borrowBook() {
        Scanner input = new Scanner(System.in);

        System.out.print("How many copies do you want to borrow? ");
        int borrowCount = input.nextInt();

        copiesAvailable -= borrowCount; // Directly reduce copies
        System.out.println("You borrowed " + borrowCount + " copies.");
    }

    // Method to display book details
    void displayBookDetails() {
        System.out.println("\n=== Book Details ===");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Copies Available: " + copiesAvailable);
    }
}

public class lab_12 {
    public static void main(String[] args) {
        // Create one Book object
        Product book = new Product();

        // Step 1: Take input from user
        book.inputDetails();

        // Step 2: Show entered details
        book.displayBookDetails();

        // Step 3: Borrow some copies
        book.borrowBook();

        // Step 4: Show updated details
        book.displayBookDetails();
    }
}
