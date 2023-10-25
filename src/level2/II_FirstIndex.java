package level2;

import java.util.Scanner;

public class II_FirstIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size for the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int index = 0; index < size; index++) {
            System.out.print("Enter element for " + index + " index: ");
            array[index] = scanner.nextInt();
        }
        System.out.println("Enter the item: ");
        int item = scanner.nextInt();

        System.out.println("First Index of " + item + " is: " + firstIndex(array, item, 0));
    }

    public static int firstIndex(int[] array, int item, int i) {
        if (i == array.length) {
            return -1;
        }

        if (array[i] == item) {
            return i;
        }

        return firstIndex(array, item, i + 1);
    }


}
