/*
 * LeetCode Question
 * 22. Generate Parenthesis
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * */


package level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class I_GenerateParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", list);
        System.out.println(list);
    }

    public static void generateParenthesis(int n, int opening, int closing, String ans, List<String> list) {
        if (opening == n && closing == n) {
            list.add(ans);
            return;
        }

        if (opening < n) {
            generateParenthesis(n, opening + 1, closing, ans + "(", list);
        }

        if (closing < opening) {
            generateParenthesis(n, opening, closing + 1, ans + ")", list);
        }
    }
}
