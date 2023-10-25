/*
 * You will be given a numeric string S. Print all the possible codes for S.
 * Following vector contains the codes corresponding to the digits mapped.
 * string table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
 * For example, string corresponding to 0 is " " and 1 is ".+@$"
 * */

package level6;

import java.util.Scanner;

public class I_Smart_Keypad {
    public static String[] table = {" ", ".+@$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the combination of numbers: ");
        String combination = scanner.nextLine();
        keypadCombination(combination, "");
    }

    public static void keypadCombination(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        int firstChar = ques.charAt(0);
        String key = table[firstChar - 48];

        for (int i = 0; i < key.length(); i++) {
            keypadCombination(ques.substring(1), ans + key.charAt(i));
        }
    }
}
