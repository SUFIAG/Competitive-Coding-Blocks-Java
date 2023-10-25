/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 25-01-2022/01/2022
 *   Time: 11:47 PM
 *   File: I_ReverseStack
 */

/**
 * CODING BLOCKS QUESTION =>
 * <p>
 * Reverse a Stack using Recursion. Do not use any extra stack.
 */

package level14_STACK;

import java.util.Stack;

public class I_ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int item = stack.pop();
        reverseStack(stack);
        insertBottom(stack, item);
    }

    private static void insertBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int x = stack.pop();
        insertBottom(stack, item);
        stack.push(x);
    }
}
