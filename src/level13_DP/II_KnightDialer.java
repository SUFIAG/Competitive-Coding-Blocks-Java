/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 24-01-2022/01/2022
 *   Time: 06:46 PM
 *   File: II_KnightDialer
 */

/**
 * LEETCODE QUESTION 931 =>
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically (with both forming the shape of an L).
 * <p>
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 * <p>
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 * <p>
 * You are allowed to place the knight on any numeric cell initially, and then you should perform n - 1
 * jumps to dial a number of length n. All jumps should be valid knight jumps.
 * <p>
 * As the answer may be very large, return the answer modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells
 * is sufficient.
 */

package level13_DP;

import java.util.Arrays;

public class II_KnightDialer {
    static int[] row = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] col = {1, -1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        int n = 2;
        int ans = 0;
        int[][][] dp = new int[n + 1][4][3];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
//                ans += knightDialer(n - 1, i, j) % 1000000007;
                ans = (ans + knightDialer_DP(n - 1, i, j, dp)) % 1000000007;
            }
        }
        System.out.println(ans);
    }

//    Recursive Solution: TLE ERROR
//public static int knightDialer(int n, int currentRow, int currentCol) {
//    if (currentRow < 0 || currentCol < 0 || currentRow >= 4 || currentCol >= 3 || (currentRow == 3 && currentCol == 0) || (currentRow == 3 && currentCol == 2)) {
//        return 0;
//    }
//
//    if (n == 0) {
//        return 1;
//    }
//
//    int count = 0;
//    for (int i = 0; i < col.length; i++) {
//        count += knightDialer(n - 1, currentRow + row[i], currentCol + col[i]) % 1000000007;
//    }
//    return count;
//}

    public static int knightDialer_DP(int n, int currentRow, int currentCol, int[][][] dp) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= 4 || currentCol >= 3 || (currentRow == 3 && currentCol == 0) || (currentRow == 3 && currentCol == 2)) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (dp[n][currentRow][currentCol] != -1) {
            return dp[n][currentRow][currentCol];
        }
        int count = 0;
        for (int i = 0; i < col.length; i++) {
            count = (count + knightDialer_DP(n - 1, currentRow + row[i], currentCol + col[i], dp)) % 1000000007;
        }
        return dp[n][currentRow][currentCol] = count;
    }
}
