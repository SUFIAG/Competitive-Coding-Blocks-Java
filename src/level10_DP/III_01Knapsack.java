/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 23-01-2022/01/2022
 *   Time: 12:51 AM
 *   File: III_01Knapsack
 */

/**
 * CODING BLOCKS PROBLEM =>
 * <p>
 * You are packing for a vacation on the sea side and you are going to carry only one bag with
 * capacity S (1 <= S <= 1000). You also have N (1<= N <= 1000) items that you might want to take with you to the
 * sea-side. Unfortunately you can not fit all of them in the knapsack, so you will have to choose.
 * For each item you are given its size and its value. You want to maximize the total value of all the items
 * you are going to bring. What is this maximum total value?
 * <p>
 * Sample Input
 * 5 4
 * 1 2 3 2 2
 * 8 4 0 5 3
 * <p>
 * Sample Output
 * 13
 */

package level10_DP;

import java.util.Arrays;
import java.util.Scanner;

public class III_01Knapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] wt = new int[m];
        int[] cost = new int[wt.length];

        for (int i = 0; i < m; i++) {
            wt[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            cost[i] = scanner.nextInt();
        }

//        System.out.println(maximumCost(wt, cost, 0, n));
        int[][] dp = new int[wt.length][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(maximumCostDP(wt, cost, 0, n, dp));
    }


//    Recursive Solution : TLE ERROR
//private static int maximumCost(int[] wt, int[] cost, int i, int w) {
//
//    if (w == 0 || i == wt.length) {
//        return 0;
//    }
//
//    int incl = 0, excl = 0;
//
//    if (w >= wt[i]) {
//        incl += cost[i] + maximumCost(wt, cost, i + 1, w - wt[i]);
//    }
//    excl = maximumCost(wt, cost, i + 1, w);
//    return Math.max(incl, excl);
//}

    private static int maximumCostDP(int[] wt, int[] cost, int i, int w, int[][] dp) {

        if (w == 0 || i == wt.length) {
            return 0;
        }

        if (dp[i][w] != -1) {
            return dp[i][w];
        }

        int incl = 0, excl = 0;

        if (w >= wt[i]) {
            incl += cost[i] + maximumCostDP(wt, cost, i + 1, w - wt[i], dp);
        }
        excl = maximumCostDP(wt, cost, i + 1, w, dp);
        return dp[i][w] = Math.max(incl, excl);
    }
}
