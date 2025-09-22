public class create_obj1 {
    String name;
    int age;

    // Constructor (object বানানোর সময় value set করার জন্য)
    create_obj1(String n, int a) {
        name = n;
        age = a;
    }

    public static void main(String[] args) {
        // আলাদা object তৈরি
        create_obj1 s1 = new create_obj1("Mridul", 21);
        create_obj1 s2 = new create_obj1("Rabby", 20);
        create_obj1 s3 = new create_obj1("Moshiour", 22);

        // আলাদা value print
        System.out.println(s1.name + " - " + s1.age);
        System.out.println(s2.name + " - " + s2.age);
        System.out.println(s3.name + " - " + s3.age);
    }
}

