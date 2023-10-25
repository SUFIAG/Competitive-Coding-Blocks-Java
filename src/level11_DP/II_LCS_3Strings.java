/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 23-01-2022/01/2022
 *   Time: 01:00 PM
 *   File: II_LCS_3Strings
 */

/**
 * CODING BLOCKS PROBLEM =>
 * <p>
 * Given 3 strings ,the task is to find the longest common sub-sequence in all three given sequences.
 * <p>
 * Sample Input
 * GHQWNV
 * SJNSDGH
 * CPGMAH
 * <p>
 * Sample Output
 * 2
 */

package level11_DP;

import java.util.Arrays;
import java.util.Scanner;

public class II_LCS_3Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        int[][][] dp = new int[str1.length()][str2.length()][str3.length()];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        System.out.println(lcsDP(str1, str2, str3, 0, 0, 0, dp));
    }

    private static int lcsDP(String str1, String str2, String str3, int i, int j, int k, int[][][] dp) {

        if (i == str1.length() || j == str2.length() || k == str3.length()) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        int ans = 0;
        if (str1.charAt(i) == str2.charAt(j) && str1.charAt(i) == str3.charAt(k)) {
            ans = 1 + lcsDP(str1, str2, str3, i + 1, j + 1, k + 1, dp);
        } else {
            int fstr1 = lcsDP(str1, str2, str3, i + 1, j, k, dp);
            int fstr2 = lcsDP(str1, str2, str3, i, j + 1, k, dp);
            int fstr3 = lcsDP(str1, str2, str3, i, j, k + 1, dp);
            ans = Math.max(fstr1, Math.max(fstr2, fstr3));
        }
        return dp[i][j][k] = ans;
    }
}
