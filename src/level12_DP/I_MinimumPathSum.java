/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 23-01-2022/01/2022
 *   Time: 03:54 PM
 *   File: I_MinimumPathSum
 */

/**
 * CODING BLOCKS & LEETCODE QUESTION =>
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * <p>
 * Output: 7
 * <p>
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */

package level12_DP;

import java.util.Arrays;
import java.util.Scanner;

public class I_MinimumPathSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
//        System.out.println(minimumPathSum(grid, 0, 0));
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(minimumPathSum_DP(grid, 0, 0, dp));
    }

    // Recursive Solution : TLE ERROR
//    private static int minimumPathSum(int[][] grid, int currentCol, int currentRow) {
//        if (currentCol >= grid[0].length || currentRow >= grid.length) {
//            return Integer.MAX_VALUE;
//        }
//
//        if (currentCol == grid[0].length - 1 && currentRow == grid.length - 1) {
//            return grid[currentRow][currentCol];
//        }
//        int down = minimumPathSum(grid, currentCol, currentRow + 1);
//        int right = minimumPathSum(grid, currentCol + 1, currentRow);
//        return Math.min(down, right) + grid[currentRow][currentCol];
//    }

    private static int minimumPathSum_DP(int[][] grid, int currentCol, int currentRow, int[][] dp) {
        if (currentCol >= grid[0].length || currentRow >= grid.length) {
            return Integer.MAX_VALUE;
        }

        if (currentCol == grid[0].length - 1 && currentRow == grid.length - 1) {
            return grid[currentRow][currentCol];
        }

        if (dp[currentRow][currentCol] != -1) {
            return dp[currentRow][currentCol];
        }

        int down = minimumPathSum_DP(grid, currentCol, currentRow + 1, dp);
        int right = minimumPathSum_DP(grid, currentCol + 1, currentRow, dp);
        return dp[currentRow][currentCol] = (Math.min(down, right) + grid[currentRow][currentCol]);
    }
}
