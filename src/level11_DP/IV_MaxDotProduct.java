/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 23-01-2022/01/2022
 *   Time: 03:47 PM
 *   File: IV_MaxDotProduct
 */

/**
 * LEETCODE QUESTION 1458 =>
 * <p>
 * Given two arrays nums1 and nums2.
 * <p>
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
 * <p>
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * <p>
 * Output: 18
 * <p>
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 */

package level11_DP;

import java.util.Arrays;

public class IV_MaxDotProduct {

    public int maxDotProduct(int[] x, int[] y) {
        int[][] dp = new int[x.length + 1][y.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -9999);
        }
        return lcsDP(x, y, x.length, y.length, dp);
    }

    private static int lcsDP(int[] x, int[] y, int i, int j, int[][] dp) {

        if (i == 0 || j == 0) {
            return -9999;
        }

        if (dp[i][j] != -9999) {
            return dp[i][j];
        }

        int ans = 0;
        int prod = x[i - 1] * y[j - 1];

        ans = prod + lcsDP(x, y, i - 1, j - 1, dp);
        int fx = lcsDP(x, y, i - 1, j, dp);
        int fy = lcsDP(x, y, i, j - 1, dp);
        ans = Math.max(prod, Math.max(ans, Math.max(fx, fy)));
        return dp[i][j] = ans;
    }
}
