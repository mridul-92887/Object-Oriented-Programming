public class MaxValueExample {

    // Method 1: maximum between 2 integers
    int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Method 2: maximum between 3 integers
    int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    // Method 3: maximum between 2 double numbers
    double max(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        MaxValueExample obj = new MaxValueExample();

        int max2 = obj.max(10, 20);
        System.out.println("Maximum between 10 and 20: " + max2);

        int max3 = obj.max(15, 25, 5);
        System.out.println("Maximum between 15, 25 and 5: " + max3);

        double maxDouble = obj.max(12.5, 9.7);
        System.out.println("Maximum between 12.5 and 9.7: " + maxDouble);
    }
}
