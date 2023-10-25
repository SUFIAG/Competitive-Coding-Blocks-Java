/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 24-01-2022/01/2022
 *   Time: 11:33 AM
 *   File: III_MinFallingPathSum_II
 */

/**
 * LEETCODE QUESTION 1289 =>
 * <p>
 * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
 * <p>
 * A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two
 * elements chosen in adjacent rows are in the same column.
 * <p>
 * Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 13
 * Explanation:
 * The possible falling paths are:
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * The falling path with the smallest sum is [1,5,7], so the answer is 13.
 */

package level12_DP;

import java.util.Arrays;

public class III_MinFallingPathSum_II {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int c = minimumPathSum_DP(matrix, i, 0, dp);
            ans = Math.min(ans, c);
        }
        return ans;
    }

    private static int minimumPathSum_DP(int[][] grid, int currentCol, int currentRow, int[][] dp) {
        if (currentCol < 0 || currentCol >= grid[0].length || currentRow >= grid.length) {
            return Integer.MAX_VALUE;
        }

        if (currentRow == grid.length - 1) {
            return grid[currentRow][currentCol];
        }

        if (dp[currentRow][currentCol] != Integer.MAX_VALUE) {
            return dp[currentRow][currentCol];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if (i != currentCol) {
                ans = Math.min(ans, minimumPathSum_DP(grid, i, currentRow + 1, dp));
            }
        }
        return dp[currentRow][currentCol] = ans + grid[currentRow][currentCol];
    }
}
