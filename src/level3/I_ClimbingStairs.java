/*
  LeetCode Question =>
  70. Climbing Stairs
  You are climbing a staircase. It takes n steps to reach the top.
  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
  <p>
  Example 1:
  <p>
  Input: n = 2
  Output: 2
  Explanation: There are two ways to climb to the top.
  1. 1 step + 1 step
  2. 2 steps
  <p>
  <p>
  Example 2:
  <p>
  Input: n = 3
  Output: 3
  Explanation: There are three ways to climb to the top.
  1. 1 step + 1 step + 1 step
  2. 1 step + 2 steps
  3. 2 steps + 1 step
 */


package level3;

import java.util.Scanner;

public class I_ClimbingStairs {
    public static int numberOfWays(int destination, int[] dp) {
//        Recursive Method
//        if (destination < 0) {
//            return 0;
//        }
//        if (destination == 1 || destination == 0) {
//            return 1;
//        } else {
//            return numberOfWays(current, destination - 2) + numberOfWays(current, destination - 1);
//        }

        // Dynamic Programming Method
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= destination; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[destination];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value for destination: ");
        int destination = scanner.nextInt();
        int[] dp = new int[destination + 1];
        System.out.println(numberOfWays(destination, dp));
    }
}
