import java.util.Scanner;

public class Calculator_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { // বারবার calculation করার জন্য loop
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.println("Choose operation (+, -, *, /, %, ^) or type 'q' to quit: ");
            char op = sc.next().charAt(0);

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
                        continue; // আবার নতুন input নিবে
                    }
                    break;

                case '%':
                    result = num1 % num2;
                    break;

                case '^': // power (num1^num2)
                    result = Math.pow(num1, num2);
                    break;

                case 'q': // Exit option
                    System.out.println("Exiting Calculator. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid Operator!");
                    continue;
            }

            System.out.println("Result = " + result);
            System.out.println("------------------------------");
        }
    }
}
