/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 24-01-2022/01/2022
 *   Time: 09:11 PM
 *   File: III_ValentineMagic
 */

/**
 * CODING BLOCKS QUESTION =>
 * <p>
 * It's Valentine's Day in Russia today. as we all know number of girls in Russia is more than number of
 * boys 😜 hence boys have an extra advantage while choosing girl for the valentine evening. Each boy has certain
 * number of chocolates and each girl has certain number of candies. Now you being the anchor of evening wants to
 * pair all the boys with girls such that the sum of absolute difference between boy's chocolate and girl's candy
 * in a pair is minimized. Of-course some girls will remain unpaired but that's okay as we are in Russia 😜
 * <p>
 * Sample Input
 * 2 5
 * 4 5
 * 1 2 3 4 5
 * <p>
 * Sample Output
 * 0
 * <p>
 * Explanation
 * we can pair boy numbered 1 with girl numbered 4 and boy numbered 2 with girl numbered 5
 */

package level13_DP;

import java.util.Arrays;
import java.util.Scanner;

public class III_ValentineMagic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] boys = new int[n];
        int[] girls = new int[m];
        for (int i = 0; i < n; i++) {
            boys[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            girls[i] = scanner.nextInt();
        }

        Arrays.sort(boys);
        Arrays.sort(girls);

        int[][] dp = new int[n][m];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(valentineMagic(boys, girls, 0, 0, dp));
    }

//     Recursive Solution: TLE ERROR
//    private static int valentineMagic(int[] boys, int[] girls, int i, int j) {
//
//        if (i == boys.length) {
//            return 0;
//        }
//
//        if (j == girls.length) {
//            return 10000000;
//        }
//
//
//        int girlsSelected = Math.abs(boys[i] - girls[j]) + valentineMagic(boys, girls, i + 1, j + 1);
//        int girlsRejected = valentineMagic(boys, girls, i, j + 1);
//        return Math.min(girlsSelected, girlsRejected);
//    }

    private static int valentineMagic(int[] boys, int[] girls, int i, int j, int[][] dp) {

        if (i == boys.length) {
            return 0;
        }

        if (j == girls.length) {
            return 10000000;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int girlsSelected = Math.abs(boys[i] - girls[j]) + valentineMagic(boys, girls, i + 1, j + 1, dp);
        int girlsRejected = valentineMagic(boys, girls, i, j + 1, dp);
        return dp[i][j] = Math.min(girlsSelected, girlsRejected);
    }
}
