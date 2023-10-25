/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 17-01-2022/01/2022
 *   Time: 11:48 PM
 *   File: IV_NQueens
 */

/*
 * CODING BLOCKS
 * You are given an empty chess board of size N*N. Find the number of ways to place N queens on the board,
 * such that no two queens can kill each other in one move. A queen can move vertically, horizontally and diagonally.
 */

package level8;

import java.util.Scanner;

public class II_NQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        System.out.println(countNQueens(board, 0));
    }

    private static int countNQueens(int[][] board, int n) {
        int ans = 0;
        if (n == board.length) {
            return 1;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, n, i)) {
                board[n][i] = 1;
                ans += countNQueens(board, n + 1);
                board[n][i] = 0;
            }
        }
        return ans;
    }

    private static boolean isSafe(int[][] board, int i, int j) {
        for (int row = i - 1; row >= 0; row--) {
            if (board[row][j] == 1) {
                return false;
            }
        }
        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1) {
                return false;
            }
        }
        for (int row = i - 1, col = j + 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1) {
                return false;
            }
        }
        return true;
    }
}
