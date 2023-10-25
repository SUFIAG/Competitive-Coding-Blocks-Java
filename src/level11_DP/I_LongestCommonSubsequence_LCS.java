/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 23-01-2022/01/2022
 *   Time: 12:09 PM
 *   File: I_LongestCommonSubsequence_LCS
 */

/**
 * LEETCODE & CODING BLOCKS PROBLEM =>
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p>
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 */

package level11_DP;

import java.util.Arrays;
import java.util.Scanner;

public class I_LongestCommonSubsequence_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
//        System.out.println(lcs(str1, str2, 0, 0));
        int[][] dp = new int[str1.length()][str2.length()];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(lcsDP(str1, str2, 0, 0, dp));
    }

    // Recursive Solution :TLE ERROR
//    private static int lcs(String str1, String str2, int i, int j) {
//
//        if (i == str1.length() || j == str2.length()) {
//            return 0;
//        }
//
//        int ans = 0;
//        if (str1.charAt(i) == str2.charAt(j)) {
//            ans = 1 + lcs(str1, str2, i + 1, j + 1);
//        } else {
//            int fstr1 = lcs(str1, str2, i + 1, j);
//            int fstr2 = lcs(str1, str2, i, j + 1);
//            ans = Math.max(fstr1, fstr2);
//        }
//        return ans;
//    }

    private static int lcsDP(String str1, String str2, int i, int j, int[][] dp) {

        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            ans = 1 + lcsDP(str1, str2, i + 1, j + 1, dp);
        } else {
            int fstr1 = lcsDP(str1, str2, i + 1, j, dp);
            int fstr2 = lcsDP(str1, str2, i, j + 1, dp);
            ans = Math.max(fstr1, fstr2);
        }
        return dp[i][j] = ans;
    }
}
