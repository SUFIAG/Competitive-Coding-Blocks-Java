/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 24-01-2022/01/2022
 *   Time: 06:19 PM
 *   File: I_Triangle
 */

/**
 * LEETCODE QUESTION 120 =>
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 */


package level13_DP;

import java.util.Arrays;
import java.util.List;

public class I_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[205][205];
        for (int[] a : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        return minimumTotalRec(triangle, 0, 0, dp);
    }

    public int minimumTotalRec(List<List<Integer>> triangle, int cc, int cr, int[][] dp) {
        if (cr == triangle.size() - 1) {
            return triangle.get(cr).get(cc);
        }
        if (dp[cr][cc] != Integer.MAX_VALUE) return dp[cr][cc];
        int c1 = minimumTotalRec(triangle, cc, cr + 1, dp);// next row me ith index
        int c2 = minimumTotalRec(triangle, cc + 1, cr + 1, dp);// next row me ith+1 index

        return dp[cr][cc] = Math.min(c1, c2) + triangle.get(cr).get(cc);

    }
}
