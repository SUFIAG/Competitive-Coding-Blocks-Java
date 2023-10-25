package level1;

import java.util.Scanner;

public class I_Fact {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number whose factorial you want to find out: ");
        int number = scanner.nextInt();
        System.out.println("Factorial of " + number + " = " + fact(number));
    }

    public static int fact(int number) {
        if (number == 0) {
            return 1;
        }

        return number * fact(number - 1);
    }
}
