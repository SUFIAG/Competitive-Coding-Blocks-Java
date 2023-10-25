/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 30-01-2022/01/2022
 *   Time: 12:01 PM
 *   File: III_NextGreaterElement_II
 */

/**
 * CODING BLOCKS QUESTION & LEETCODE QUESTION 503 =>
 * <p>
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next
 * greater number for every element in nums.
 * <p>
 * The next greater number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
package level16_STACK;

import java.util.Scanner;
import java.util.Stack;

public class III_NextGreaterElement_II {
    public static void main(String[] args) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        findGreaterElement(arr);
    }

    private static void findGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int size = arr.length;
        int[] result = new int[size];

        for (int i = size * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i % size] >= stack.peek()) {
                stack.pop();
            }

            if (i < size) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                } else {
                    result[i] = -1;
                }
            }
            stack.push(arr[i % size]);
        }

        for (int ans : result) {
            System.out.println(ans + " ");
        }
    }
}
