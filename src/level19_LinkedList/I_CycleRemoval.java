/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 01-02-2022/02/2022
 *   Time: 11:23 AM
 *   File: I_CycleRemoval
 */

/**
 * CODING BLOCKS QUESTION =>
 * <p>
 * Write a code to remove the cycle present in the linked list.
 */

package level19_LinkedList;

public class I_CycleRemoval {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode head;
    public ListNode size;

    static class Solution {

        // Floyd Cycle detection Method
        public static ListNode meetingPoint() {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return slow;
                }
            }
            return null;
        }

        // O(n^2) approach
        public static void removeCycle() {
            ListNode meetingPoint = meetingPoint();

            if (meetingPoint == null) {
                return;
            }

            ListNode start = head;
            while (start != null) {
                ListNode temp = meetingPoint;
                while (temp.next != meetingPoint) {
                    if (temp.next == start) {
                        temp.next = null;
                        return;
                    }
                    temp = temp.next;
                }
                start = start.next;
            }
        }

        // O(n) approach
        public static void removeCycle2() {
            ListNode meetingPoint = meetingPoint();

            if (meetingPoint == null) {
                return;
            }

            ListNode temp = meetingPoint;
            int count = 1;
            ListNode fast = head;
            ListNode slow = head;

            // Count number of nodes inside the cycle
            while (temp.next != meetingPoint) {
                count++;
                temp = temp.next;
            }

            // Move Fast Pointer Count Steps Ahead From Slow
            for (int i = 0; i < count; i++) {
                fast = fast.next;
            }

            while (slow.next != fast.next) {
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = null;
        }

        // Floyd Cycle Algorithm => It says that don't move the fast pointer counter times ahead.
        public static void floydCycleRemoval() {
            ListNode meetingPoint = meetingPoint();

            if (meetingPoint == null) {
                return;
            }
            ListNode fast = meetingPoint;
            ListNode slow = head;

            while (slow.next != fast.next) {
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = null;
        }
    }
}
