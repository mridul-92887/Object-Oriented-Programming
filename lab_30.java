// Base class: Shop
class Shop {
    protected String email;

    public Shop(String email){
        this.email = email;
    }
}

// Agora is a type of Shop
class Agora extends Shop {
    private String location;

    public Agora(String email, String location) {
        super(email); // call parent constructor
        this.location = location;
    }

    // Agora sells an item
    public void sale(Item item) {
        System.out.println("Selling item at Agora...");
        item.display();
    }

    public void displayInfo() {
        System.out.println("Shop Email: " + email);
        System.out.println("Location: " + location);
    }
}

// Base Item class
class Item {
    protected double unitPrice;

    public Item(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void display() {
        System.out.println("Item price: " + unitPrice);
    }
}

// Book is a type of Item
class Book extends Item {
    private int isbnNumber;

    public Book(double unitPrice, int isbnNumber) {
        super(unitPrice);
        this.isbnNumber = isbnNumber;
    }

    @Override
    public void display() {
        System.out.println("Book ISBN: " + isbnNumber + ", Price: " + unitPrice);
    }
}

// Main class to test
public class lab_30 {
    public static void main(String[] args) {
        // Create a shop (Agora)
        Agora agora = new Agora("agora@gmail.com", "Dhaka");

        // Create a book item
        Book book = new Book(450.0, 987654);

        // Display shop info
        agora.displayInfo();

        // Agora sells a book
        System.out.println("\n--- Sale Information ---");
        agora.sale(book);
    }
}
