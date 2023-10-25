/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 18-01-2022/01/2022
 *   Time: 12:21 AM
 *   File: V_BoxPermutation
 */

/*
 *  CODING BLOCKS CLASS QUESTION
 *
 *  In how many ways can we select r boxes from total n number of boxes. (Permutation)
 *  Print all possible combination of boxes.
 * */

package level8;

import java.util.Scanner;

public class III_BoxPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        box_Perm(0, r, new boolean[n], "");
    }

    private static void box_Perm(int currentBox, int totalBoxes, boolean[] boxes, String ans) {
        if (currentBox == totalBoxes) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                box_Perm(currentBox + 1, totalBoxes, boxes, ans + i);
                boxes[i] = false;
            }
        }
    }
}
