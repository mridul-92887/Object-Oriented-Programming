import java.util.Scanner;

public class Customer {
    private int custid;
    private String name;
    private String category;
    
    public Customer(int custid, String name) {
        this.custid = custid;
        this.name = name;
       // this.category = "Regular";
    }
    
    public void display() {
        System.out.println("ID: " + custid + ", Name: " + name + ", Category: " + category);
    }
    
    public void setCat(String category) {
        this.category = category;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        Customer customer = new Customer(id, name);
        customer.setCat(category);

        System.out.println("\n--- Customer Information ---");
        customer.display();
        
        scanner.close();
    }
}