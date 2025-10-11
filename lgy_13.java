import java.util.Scanner;

class Product {
    // Data members
    String productName;
    double price;
    int stockQuantity;
    
    // Method to purchase product
    void purchaseProduct(int quantity) {
        if (quantity <= stockQuantity) {
            double totalPrice = quantity * price;
            stockQuantity -= quantity;
            System.out.println("Purchase successful! Total price: $" + totalPrice);
        } else {
            System.out.println("Insufficient stock available");
        }
    }
    
    // Method to display product details
    void displayProductDetails() {
        System.out.println("\nProduct Details:");
        System.out.println("Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Available Stock: " + stockQuantity);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create two Product objects
        Product product1 = new Product();
        Product product2 = new Product();
        
        // Input for first product
        System.out.println("Enter details for Product 1:");
        System.out.print("Product Name: ");
        product1.productName = scanner.nextLine();
        System.out.print("Price: ");
        product1.price = scanner.nextDouble();
        System.out.print("Stock Quantity: ");
        product1.stockQuantity = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Input for second product
        System.out.println("\nEnter details for Product 2:");
        System.out.print("Product Name: ");
        product2.productName = scanner.nextLine();
        System.out.print("Price: ");
        product2.price = scanner.nextDouble();
        System.out.print("Stock Quantity: ");
        product2.stockQuantity = scanner.nextInt();
        
        // Display initial details
        System.out.println("\n--- Initial Product Details ---");
        product1.displayProductDetails();
        product2.displayProductDetails();
        
        // Purchase operation
        System.out.println("\n--- Purchase Operation ---");
        System.out.print("Enter which product to purchase (1 or 2): ");
        int productChoice = scanner.nextInt();
        System.out.print("Enter quantity to purchase: ");
        int purchaseQuantity = scanner.nextInt();
        
        if (productChoice == 1) {
            product1.purchaseProduct(purchaseQuantity);
        } else if (productChoice == 2) {
            product2.purchaseProduct(purchaseQuantity);
        } else {
            System.out.println("Invalid product choice!");
        }
        
        // Display final details
        System.out.println("\n--- Final Product Details ---");
        product1.displayProductDetails();
        product2.displayProductDetails();
        
        scanner.close();
    }
}