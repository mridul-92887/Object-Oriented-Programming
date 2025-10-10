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

public class Array_1 {
    public static void main(String[] args) {

        
        Product p1 = new Product("Ice Cream", 50.0);
        Product p2 = new Product("Burger", 100.0);
        Product p3 = new Product("Juice", 30.0);
        Product p4 = new Product("Pizza", 150.0);
        Product p5 = new Product("Cake", 200.0);

  
        Product[] factory = new Product[5];
        factory[0] = p1;
        factory[1] = p2;
        factory[2] = p3;
        factory[3] = p4;
        factory[4] = p5;

  
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
