/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 21-01-2022/01/2022
 *   Time: 10:17 AM
 *   File: I_ClimbingStairs
 */

/**
 * Reaching to the top of a staircase, it takes n steps.
 * The task can be accomplished either by climbing 1 step or 2 steps at a time.
 * In how many ways can you climb to the top.
 * Note: n will be a positive integer.
 */


package level9_DP;

import java.util.Scanner;

public class I_ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        System.out.println(possibleNumberOfWays(n, dp, 0));
    }

    private static int possibleNumberOfWays(int n, int[] dp, int current) {
        if (current == n) {
            return 1;
        }
        if (current > n) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int oneStep = possibleNumberOfWays(n, dp, current + 1);
        int twoSteps = possibleNumberOfWays(n, dp, current + 2);
        return dp[current] = oneStep + twoSteps;
    }
}
