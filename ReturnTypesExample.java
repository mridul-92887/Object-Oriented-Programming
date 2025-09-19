public class ReturnTypesExample {

    // 1. void (no return value)
    static void myVoidMethod() {
        System.out.println("This method returns nothing (void)");
    }

    // 2. int
    static int myIntMethod(int a, int b) {
        return a + b;
    }

    // 3. double
    static double myDoubleMethod(double r) {
        return 3.1416 * r * r;
    }

    // 4. float
    static float myFloatMethod(float x, float y) {
        return x / y;
    }

    // 5. long
    static long myLongMethod(long a, long b) {
        return a * b;
    }

    // 6. short
    static short myShortMethod(short a, short b) {
        return (short)(a + b);
    }

    // 7. byte
    static byte myByteMethod(byte a, byte b) {
        return (byte)(a * b);
    }

    // 8. char
    static char myCharMethod() {
        return 'A';
    }

    // 9. boolean
    static boolean myBooleanMethod(int num) {
        return num % 2 == 0;
    }

    // 10. String (reference type)
    static String myStringMethod(String name, int age) {
        return name + " is " + age + " years old";
    }

    // 11. Array (reference type)
    static int[] myArrayMethod() {
        return new int[]{10, 20, 30, 40};
    }

    // 12. Object (reference type - generic)
    static Object myObjectMethod() {
        return "I am an Object";
    }

    // 13. Wrapper class return
    static Integer myIntegerWrapperMethod(int a) {
        return a * 10;
    }

    // 14. Custom class return
    static ReturnTypesExample myCustomClassMethod() {
        return new ReturnTypesExample();
    }

    public static void main(String[] args) {
        myVoidMethod();
        System.out.println(myIntMethod(5, 7));
        System.out.println(myDoubleMethod(5.5));
        System.out.println(myFloatMethod(10.5f, 2.5f));
        System.out.println(myLongMethod(100000L, 200000L));
        System.out.println(myShortMethod((short)5, (short)7));
        System.out.println(myByteMethod((byte)3, (byte)4));
        System.out.println(myCharMethod());
        System.out.println(myBooleanMethod(10));
        System.out.println(myStringMethod("Mridul", 22));

        int[] arr = myArrayMethod();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(myObjectMethod());
        System.out.println(myIntegerWrapperMethod(15));
        System.out.println(myCustomClassMethod());
    }
}
