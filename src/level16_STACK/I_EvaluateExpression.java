/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 30-01-2022/01/2022
 *   Time: 11:13 AM
 *   File: I_EvaluateExpression
 */

/**
 * CODING BLOCKS QUESTION & LEETCODE QUESTION 150 =>
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * <p>
 * Sample Input
 * 2
 * 231*+9-
 * 123+*8-
 * <p>
 * Sample Output
 * -4
 * -3
 */

package level16_STACK;

import java.util.Scanner;
import java.util.Stack;

public class I_EvaluateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {
            String str = scanner.next();
            System.out.println(evaluatePostfix(str));
        }
    }

    // Coding Blocks Solution
    private static long evaluatePostfix(String str) {
        Stack<String> stack = new Stack<>();
        int x, y;
        String result;
        String choice;
        int value = 0;
        String p = "";
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (character != '+' && character != '-'
                    && character != '*' && character != '/') {
                stack.push(String.valueOf(character));
                continue;
            } else {
                choice = String.valueOf(character);
            }

            switch (choice) {
                case "+" -> {
                    x = Integer.parseInt(String.valueOf(stack.pop()));
                    y = Integer.parseInt(String.valueOf(stack.pop()));
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                }
                case "-" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                }
                case "*" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                }
                case "/" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                }
                default -> {
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    // Leetcode Solution
    public int evalRPN(String[] str) {
        Stack<String> stack = new Stack<>();
        int x, y;
        String result;
        String choice;
        int value = 0;
        String p = "";
        for (String character : str) {
            if (!character.equals("+") && !character.equals("-")
                    && !character.equals("*") && !character.equals("/")) {
                stack.push(character);
                continue;
            } else {
                choice = character;
            }

            switch (choice) {
                case "+" -> {
                    x = Integer.parseInt(String.valueOf(stack.pop()));
                    y = Integer.parseInt(String.valueOf(stack.pop()));
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                }
                case "-" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                }
                case "*" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                }
                case "/" -> {
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                }
                default -> {
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
