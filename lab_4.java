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

public class lab_4 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Atikul Hasan Mridul";
        s1.id = 365;
        s1.department = "CSE";

        s2.name = "Rifat Mahmud";
        s2.id = 151;
        s2.department = "CSE";

        System.out.println("Student 1 Information:");
        s1.showInfo();

        System.out.println("\nStudent 2 Information:");
        s2.showInfo();
    }
}
