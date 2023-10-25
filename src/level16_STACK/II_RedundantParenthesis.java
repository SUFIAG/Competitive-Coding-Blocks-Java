/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 30-01-2022/01/2022
 *   Time: 11:31 AM
 *   File: II_RedundantParenthesis
 */

/**
 * CODING BLOCKS QUESTION =>
 * <p>
 * You are given a balanced expression. You have to find if it contains duplicate parentheses or not.
 * A set of parentheses are duplicate if same subexpression is surrounded by multiple parenthesis.
 * <p>
 * Sample Input
 * 2
 * (((a+(b))+(c+d)))
 * ((a+(b))+(c+d))
 * <p>
 * Sample Output
 * Duplicate
 * Not Duplicates
 * <p>
 * Explanation
 * For 1st test case : The subexpression "a+(b)" is surrounded by two pairs of brackets.
 */

package level16_STACK;

import java.util.Scanner;
import java.util.Stack;

public class II_RedundantParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {
            String str = scanner.next();
            if (duplicateParenthesis(str)) {
                System.out.println("Duplicate");
            } else {
                System.out.println("Not Duplicates");
            }
        }
    }

    private static boolean duplicateParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);

            if (character == ')') {
                char top = stack.pop();

                int inBetween = 0;

                while (top != '(') {
                    inBetween++;
                    top = stack.pop();
                }
                if (inBetween < 1) {
                    return true;
                }
            } else {
                stack.push(character);
            }
        }
        return false;
    }
}
