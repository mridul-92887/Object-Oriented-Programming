import java.util.Scanner;

public class ArrayInputOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array size input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        // Array declare
        int[] arr = new int[n];

        // Array input
        System.out.println("Enter " + n + " numbers: ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Array output
        System.out.println("Array elements are: ");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
