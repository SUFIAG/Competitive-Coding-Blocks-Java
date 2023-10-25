/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 27-01-2022/01/2022
 *   Time: 11:29 PM
 *   File: II_Histogram
 */

/**
 * CODING BLOCKS QUESTION & LEETCODE QUESTION 84 =>
 * <p>
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a
 * number of contiguous bars.
 * <p>
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */

package level15_STACK;

import java.util.Scanner;
import java.util.Stack;

public class II_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maximumArea(arr));
    }

    private static int maximumArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < arr.length; ) {
            if (stack.isEmpty() || arr[i] > arr[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int right = i;
                int height = arr[stack.pop()];
                if (stack.isEmpty()) {
                    int area = height * right;
                    maxArea = Math.max(maxArea, area);
                } else {
                    int left = stack.peek();
                    int area = height * (right - left - 1);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        int right = arr.length;
        while (!stack.isEmpty()) {
            int height = arr[stack.pop()];
            if (stack.isEmpty()) {
                int area = height * right;
                maxArea = Math.max(maxArea, area);
            } else {
                int left = stack.peek();
                int area = height * (right - left - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
