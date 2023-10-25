package level1;

import java.util.Scanner;

public class III_PrintCharacterReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String to print its character: ");
        String string = scanner.nextLine();
        System.out.println("The characters of the string are => ");
        printCharacterReverse(string);
    }

    public static void printCharacterReverse(String string) {
        if (string.length() == 0) {
            return;
        }

        printCharacterReverse(string.substring(1));
        char firstChar = string.charAt(0);
        System.out.println(firstChar);
    }
}
