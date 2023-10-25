/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 24-01-2022/01/2022
 *   Time: 11:24 AM
 *   File: II_MinFallingPathSum
 */

/**
 * LEETCODE QUESTION 931 =>
 * <p>
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either
 * directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
 * (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * <p>
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum as shown.
 */

package level12_DP;

import java.util.Arrays;

public class II_MinFallingPathSum {
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

        int down = minimumPathSum_DP(grid, currentCol, currentRow + 1, dp);
        int rightDiagonal = minimumPathSum_DP(grid, currentCol + 1, currentRow + 1, dp);
        int leftDiagonal = minimumPathSum_DP(grid, currentCol - 1, currentRow + 1, dp);
        return dp[currentRow][currentCol] = (Math.min(down, Math.min(rightDiagonal, leftDiagonal)) + grid[currentRow][currentCol]);
    }
}
