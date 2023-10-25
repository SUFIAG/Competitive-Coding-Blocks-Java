package level3;

import java.util.Scanner;

public class II_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to find the fibonacci: ");
        int number = scanner.nextInt();
        System.out.println(fibonacci(number));
    }

    public static int fibonacci(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
