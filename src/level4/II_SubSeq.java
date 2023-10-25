/*
 * Problem Statement => Generate the subsequence of a given string.
 * Example: String = abcd
 *          Subsequences = a, b, c, d, ab, bc, cd, abc, bcd, abcd
 * */


package level4;

import java.util.Scanner;

public class II_SubSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String string = scanner.nextLine();
        generateSubSequences(string, "");
    }

    public static void generateSubSequences(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        char firstChar = ques.charAt(0);
        generateSubSequences(ques.substring(1), ans);
        generateSubSequences(ques.substring(1), ans + firstChar);
    }
}
