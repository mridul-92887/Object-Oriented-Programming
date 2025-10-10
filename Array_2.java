import java.util.Scanner;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product Name: " + name + ", Price: " + price);
    }
}
public class Array_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] factory = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i+1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            factory[i] = new Product(name, price);
        }

        System.out.println("\n===== Loop: All Products =====");
        for (int i = 0; i < factory.length; i++) {
            System.out.print((i+1) + "th Product: ");
            factory[i].display();
        }

        System.out.println("\n===== Specific Products =====");
        for (int i = 0; i < factory.length; i++) {
            System.out.print((i+1) + "th Product: ");
            factory[i].display();
        }
        sc.close();
    }
}
