/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 22-01-2022/01/2022
 *   Time: 07:01 PM
 *   File: II_MinCostClimbingStairs
 */

/**
  CODING BLOCKS & LEETCODE QUESTION =>
  <p>
  You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
  Once you pay the cost, you can either climb one or two steps.
  You can either start from the step with index 0, or the step with index 1.
  <p>
  Return the minimum cost to reach the top of the floor.
  <p>
  <p>
  Example 1:
  <p>
  Input: cost = [10,15,20]
  Output: 15
  Explanation: You will start at index 1.
  - Pay 15 and climb two steps to reach the top.
  The total cost is 15.
 */


package level9_DP;

import java.util.Arrays;

public class III_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] costs) {
        int n = costs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(costs[i - 1] + dp[i - 1], costs[i - 2] + dp[i - 2]);
        }

        return Math.min(costs[n - 1] + dp[n - 1], costs[n - 2] + dp[n - 2]);
    }
}
