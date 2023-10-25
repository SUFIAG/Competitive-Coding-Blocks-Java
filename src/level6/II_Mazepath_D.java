/*
 * Take as input N1 and N2, both numbers. N1 and N2 is the number of rows and columns on a rectangular board.
 * Our player starts in top-left corner of the board and must reach bottom-right corner. In one move the player can
 * move 1 step horizontally (right) or 1 step vertically (down) or 1 step diagonally (south-east).
 *
 * a. Write a recursive function which returns the count of different ways the player can travel across the board.
 *    Print the value returned.
 *
 * b. Write a recursive function which prints moves for all valid paths across the board (void is the return type for function).
 * */


package level6;

import java.util.Scanner;

public class II_Mazepath_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        System.out.println(maze_D(0, 0, row - 1, col - 1, ""));
    }

    public static int maze_D(int currentRow, int currentCol, int expectedRow, int expectedCol, String ans) {
        if (currentRow == expectedRow && currentCol == expectedCol) {
            System.out.println(ans);
            return 1;
        } else if (currentRow > expectedRow || currentCol > expectedCol) {
            return 0;
        } else {
            int count = 0;
            count += maze_D(currentRow, currentCol + 1, expectedRow, expectedCol, ans + 'H');
            count += maze_D(currentRow + 1, currentCol, expectedRow, expectedCol, ans + 'V');
            count += maze_D(currentRow + 1, currentCol + 1, expectedRow, expectedCol, ans + 'D');
            return count;
        }
    }
}
