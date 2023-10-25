/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 22-01-2022/01/2022
 *   Time: 02:30 PM
 *   File: I_CoinChanges
 */

/**
 * Coding Blocks Problem =>
 * <p>
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each
 * of S = { S1, S2, .. , Sm} valued coins, In how many ways can we make the change? The order of coins does not matter.
 * <p>
 * <p>
 * Sample Input
 * 10 4
 * 2 5 3 6
 * <p>
 * Sample Output
 * 5
 */

package level10_DP;

import java.util.Arrays;
import java.util.Scanner;

public class I_CoinChanges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int size = scanner.nextInt();
        int[] coin = new int[size];

        for (int i = 0; i < size; i++) {
            coin[i] = scanner.nextInt();
        }
        int[][] dp = new int[amount + 1][size];
//        for (int i = 0; i < amount; i++) {
//            for (int j = 0; j < size; j++) {
//                dp[i][j] = -1;
//            }
//        }
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(numberOfWays_DP(coin, amount, 0, dp));

//        System.out.println(numberOfWays(coin, amount, 0));
    }

    // This recursive solution will give TLE Error i.e. TIME LIMIT EXCEED ERROR.
//    private static int numberOfWays(int[] coin, int amount, int i) {
//        if (amount == 0) {
//            return 1;
//        }
//
//        if (i == coin.length) {
//            return 0;
//        }
//
//        int inc = 0, exc = 0;
//
//        if (amount >= coin[i]) {
//            inc += numberOfWays(coin, amount - coin[i], i);
//        }
//        exc += numberOfWays(coin, amount, i + 1);
//        return inc + exc;
//    }

    private static int numberOfWays_DP(int[] coin, int amount, int i, int[][] dp) {
        if (amount == 0) {
            return 1;
        }

        if (i == coin.length) {
            return 0;
        }

        if (dp[amount][i] != -1) {
            return dp[amount][i];
        }

        int inc = 0, exc = 0;

        if (amount >= coin[i]) {
            inc += numberOfWays_DP(coin, amount - coin[i], i, dp);
        }
        exc += numberOfWays_DP(coin, amount, i + 1, dp);
        return dp[amount][i] = inc + exc;
    }
}
