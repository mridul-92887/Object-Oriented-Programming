import java.util.Scanner;

public class create_obj3 {
    String name;
    int age;

    // Constructor
    create_obj3(String n, int a) {
        name = n;
        age = a;
    }

    // Method to display info
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // user input নেয়া
        System.out.print("Enter student name: ");
        String n = sc.nextLine();

        System.out.print("Enter student age: ");
        int a = sc.nextInt();

        // object বানানো
        create_obj3 student = new create_obj3(n, a);

        // method call করে details দেখানো
        System.out.println("\n--- Student Details ---");
        student.display();

        sc.close();
    }
}
