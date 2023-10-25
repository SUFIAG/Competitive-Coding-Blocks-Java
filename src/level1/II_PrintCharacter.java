package level1;

import java.util.Scanner;

public class II_PrintCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String to print its character: ");
        String string = scanner.nextLine();
        System.out.println("The characters of the string are => ");
        printCharacter(string);
    }

    public static void printCharacter(String string) {
        if (string.length() == 0) {
            return;
        }

        char firstChar = string.charAt(0);
        System.out.println(firstChar);
        printCharacter(string.substring(1));
    }
}
