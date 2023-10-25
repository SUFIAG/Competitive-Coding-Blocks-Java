/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 18-01-2022/01/2022
 *   Time: 11:00 PM
 *   File: I_TowerOfHanoi
 */

package level8;

public class I_TowerOfHanoi {
    public static void main(String[] args) {
        int numberOfDisks = 3;
        towerOfHanoi(numberOfDisks, "Source", "Helper", "Destination");
    }

    public static void towerOfHanoi(int numberOfDisks, String source, String helper, String destination) {
//  The main crux of Tower Of Hanoi problem is that try to move n - 1 disks from source to helper using recursion.

        if (numberOfDisks == 0) {
            return;
        }
        towerOfHanoi(numberOfDisks - 1, source, destination, helper);
        System.out.println("Move " + numberOfDisks + " from " + source + " to " + destination);
        towerOfHanoi(numberOfDisks - 1, helper, source, destination);
    }
}
