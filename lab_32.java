import java.util.ArrayList;
class Student {
    String name;
    int roll;

    Student(String name, int roll){
        this.name = name;
        this.roll = roll;
    }
}

public class lab_32 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        Student s1 = new Student("Rafi", 101);
        Student s2 = new Student("Shuvo", 102);

        students.add(s1);
        students.add(s2);

        for(Student s : students){
            System.out.println("Name: " + s.name + ", Roll: " + s.roll);
        }
    }
}
