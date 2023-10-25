/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 23-01-2022/01/2022
 *   Time: 02:59 PM
 *   File: III_UncrossedLine
 */

/**
 * CODING BLOCKS & LEETCODE QUESTION =>
 * <p>
 * You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2
 * (in the order they are given) on two separate horizontal lines.
 * <p>
 * We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 * nums1[i] == nums2[j], and
 * the line we draw does not intersect any other connecting (non-horizontal) line.
 * <p>
 * <p>
 * Note that a connecting line cannot intersect even at the endpoints
 * (i.e., each number can only belong to one connecting line).
 * <p>
 * Return the maximum number of connecting lines we can draw in this way.
 * <p>
 * Sample Input
 * 6 5
 * 1 3 7 1 7 5
 * 1 9 2 5 1
 * <p>
 * Sample Output
 * 2
 */

package level11_DP;

import java.util.Arrays;
import java.util.Scanner;

public class III_UncrossedLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[m];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            y[i] = sc.nextInt();
        }
        int[][] dp = new int[n][m];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(lcsDP(x, y, 0, 0, dp));
    }

    private static int lcsDP(int[] x, int[] y, int i, int j, int[][] dp) {

        if (i == x.length || j == y.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (x[i] == y[j]) {
            ans = 1 + lcsDP(x, y, i + 1, j + 1, dp);
        } else {
            int fx = lcsDP(x, y, i + 1, j, dp);
            int fy = lcsDP(x, y, i, j + 1, dp);
            ans = Math.max(fx, fy);
        }
        return dp[i][j] = ans;
    }
}
