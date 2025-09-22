public class create_obj {
    int x = 5;
    String s = "Mridul";
    float f = 987.234f; // corrected variable name
    char c = 'M';

    public static void main(String[] args) {
        // Creating multiple objects
        create_obj Obj_1 = new create_obj();
        create_obj Obj_2 = new create_obj();

        // Accessing object variables
        System.out.println("Obj_1: " + Obj_1.x + ", " + Obj_1.s + ", " + Obj_1.f + ", " + Obj_1.c);
        System.out.println("Obj_2: " + Obj_2.x + ", " + Obj_2.s + ", " + Obj_2.f + ", " + Obj_2.c);
    }
}
