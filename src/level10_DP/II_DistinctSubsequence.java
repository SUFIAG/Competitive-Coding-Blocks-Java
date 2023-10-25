/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 22-01-2022/01/2022
 *   Time: 11:50 PM
 *   File: II_DistinctSubsequence
 */

/**
 * LEETCODE QUESTION 115 =>
 * <p>
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * <p>
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of
 * the characters without disturbing the remaining characters' relative positions.
 * (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 */

package level10_DP;

import java.util.Arrays;

public class II_DistinctSubsequence {
    public int numDistinct(String s, String t) {
//        return numberOfWays(s, t, 0, 0);
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return numberOfWaysDP(s, t, 0, 0, dp);
    }

//    Recursive Solution : TLE ERROR
//private int numberOfWays(String s, String t, int m, int n) {
//    if (n == t.length()) {
//        return 1;
//    }
//
//    if (m == s.length()) {
//        return 0;
//    }
//    int inc = 0, exc = 0;
//    if (s.charAt(m) == t.charAt(n)) {
//        inc += numberOfWays(s, t, m + 1, n + 1);
//    }
//    exc += numberOfWays(s, t, m + 1, n);
//    return inc + exc;

    private int numberOfWaysDP(String s, String t, int m, int n, int[][] dp) {
        if (n == t.length()) {
            return 1;
        }

        if (m == s.length()) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int inc = 0, exc = 0;
        if (s.charAt(m) == t.charAt(n)) {
            inc += numberOfWaysDP(s, t, m + 1, n + 1, dp);
        }
        exc += numberOfWaysDP(s, t, m + 1, n, dp);
        return dp[m][n] = inc + exc;
    }
}
