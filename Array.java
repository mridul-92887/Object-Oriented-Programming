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

public class Array{
    public static void main(String[] args) {

        Product[] factory = new Product[5];

        factory[0] = new Product("Ice Cream", 50.0);
        factory[1] = new Product("Burger", 100.0);
        factory[2] = new Product("Juice", 30.0);
        factory[3] = new Product("Pizza", 150.0);
        factory[4] = new Product("Cake", 200.0);


        System.out.println("===== Loop: All Products =====");
        for (int i = 0; i < factory.length; i++) {
            System.out.print((i+1) + "th Product: ");
            factory[i].display();
        }

        System.out.println("\n===== Specific Products =====");
        System.out.print("1st Product: "); factory[0].display();
        System.out.print("2nd Product: "); factory[1].display();
        System.out.print("3rd Product: "); factory[2].display();
        System.out.print("4th Product: "); factory[3].display();
        System.out.print("5th Product: "); factory[4].display();
    }
}
