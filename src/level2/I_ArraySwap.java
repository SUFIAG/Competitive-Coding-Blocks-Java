package level2;

import java.util.Arrays;
import java.util.Scanner;

public class I_ArraySwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the common size for the arrays: ");
        int size = scanner.nextInt();
        int[] firstArray = new int[size];
        int[] secondArray = new int[size];
        for (int index = 0; index < size; index++) {
            System.out.print("Enter element for " + index + " index: ");
            firstArray[index] = scanner.nextInt();
        }

        for (int index = 0; index < size; index++) {
            System.out.print("Enter element for " + index + " index: ");
            secondArray[index] = scanner.nextInt();
        }

        System.out.println("Arrays Before Swapping: ");
        System.out.println("First array : " + Arrays.toString(firstArray));
        System.out.println("Second array : " + Arrays.toString(secondArray));

        System.out.println("Arrays After Swapping: ");
        swapArrays(firstArray, secondArray);


    }

    public static void swapArrays(int[] firstArray, int[] secondArray) {
        int[] tempArray = firstArray;
        firstArray = secondArray;
        secondArray = tempArray;
        System.out.println("First array : " + Arrays.toString(firstArray));
        System.out.println("Second array : " + Arrays.toString(secondArray));

    }
}
