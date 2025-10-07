import java.util.Scanner;  // user input নেয়ার জন্য

class Student {
    String name;
    int id;
    String department;

    void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
    }
}

public class lab_5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // Scanner object তৈরি করা হলো

        Student s1 = new Student();
        Student s2 = new Student();

        System.out.println("Enter details for Student 1:");
        System.out.print("Enter Name: ");
        s1.name = input.nextLine();

        System.out.print("Enter ID: ");
        s1.id = input.nextInt();
        input.nextLine(); // newline clear করার জন্য

        System.out.print("Enter Department: ");
        s1.department = input.nextLine();

        System.out.println("\nEnter details for Student 2:");
        System.out.print("Enter Name: ");
        s2.name = input.nextLine();

        System.out.print("Enter ID: ");
        s2.id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Department: ");
        s2.department = input.nextLine();

        System.out.println("\n--- Student 1 Information ---");
        s1.showInfo();

        System.out.println("\n--- Student 2 Information ---");
        s2.showInfo();

        input.close(); // Scanner বন্ধ করা ভালো অভ্যাস
    }
}
