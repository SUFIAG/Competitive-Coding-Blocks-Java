/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 21-01-2022/01/2022
 *   Time: 10:53 AM
 *   File: II_HouseRobber
 */

/**
 * LeetCode Problem 198 =>
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed
 * ,the only constraint stopping you from robbing each of them is that adjacent houses have security systems
 * connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money
 * you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */

package level9_DP;

import java.util.Arrays;

public class II_HouseRobber {
    // Wrong Approach
/*    public int rob(int[] nums) {
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        return Math.max(evenSum, oddSum);

    }
 */

    // Recursive Approach: TIME LIMIT EXCEED
//    public int robRecursive(int[] nums, int i) {
//
//        if (i >= nums.length) {
//            return 0;
//        }
//
//        int rob = nums[i] + robRecursive(nums, i + 2);
//        int notRob = robRecursive(nums, i + 1);
//
//        return Math.max(rob, notRob);
//    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); // We are filling the dp array with -1 because in the question constraint it is
        // mentioned that 0 <= nums[i] <= 400 so we will have to fill the dp array with some
        // unique value.
        return robDP(nums, 0, dp);
    }

    // Optimized Solution: DP Used
    public int robDP(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int rob = nums[i] + robDP(nums, i + 2, dp);
        int dontRob = robDP(nums, i + 1, dp);
        return dp[i] = Math.max(rob, dontRob);
    }
}
