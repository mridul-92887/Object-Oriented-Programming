import java.util.Scanner;

public class lab_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.print("Choose operation (+, -, *, /): ");
            char op = sc.next().charAt(0);

            boolean valid = true;
            double result = 0;

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero.");
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
                    valid = false;
            }

            if (valid) {
                if (op == '/' && result == (int) result) {
                    System.out.println("Result: " + (int) result);
                } else {
                    System.out.println("Result: " + result);
                }
            }
        }
    }
}
