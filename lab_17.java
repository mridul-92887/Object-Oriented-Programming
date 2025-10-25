class Student {
    private int id;
    private String name;

    // 🔹 Setter method to set data
    void setId(int i) {
        id = i;
    }

    void setName(String n) {
        name = n;
    }

    // 🔹 Getter method to get data
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
}

public class lab_17 {
    public static void main(String[] args) {
        Student s1 = new Student();

        // set data using setter methods
        s1.setId(101);
        s1.setName("Mridul");

        // get data using getter methods
        System.out.println("Student ID: " + s1.getId());
        System.out.println("Name: " + s1.getName());
    }
}
