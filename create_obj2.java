import java.util.Scanner;

public class create_obj2 {
    String name;
    int age;

    // Constructor
    create_obj2(String n, int a) {
        name = n;
        age = a;
    }

    // Method to display info
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input নেয়ার জন্য কতজন student বানাবো জিজ্ঞাসা করবো
        System.out.print("How many students? ");
        int n = sc.nextInt();
        sc.nextLine(); // nextInt এর পরে newline খাওয়ার জন্য

        // Array বানালাম multiple objects রাখার জন্য
        create_obj2[] students = new create_obj2[n];

        // Loop দিয়ে user থেকে data নেয়া
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter age of student " + (i + 1) + ": ");
            int age = sc.nextInt();
            sc.nextLine(); // newline clear

            // object তৈরি করে array তে রাখা
            students[i] = new create_obj2(name, age);
        }

        // সব student এর details print
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < n; i++) {
            students[i].display();
        }

        sc.close();
    }
}
