import java.util.Scanner;

class Student {
    String name;
    int roll;
    double marks;

    Student(String n, int r, double m) {
        name = n;
        roll = r;
        marks = m;
    }

    void showResult() {
        System.out.println("\nName: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Marks: " + marks);

        if (marks >= 40) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}

public class lab_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s1 = new Student(name, roll, marks);
        s1.showResult();

        sc.close();
    }
}
