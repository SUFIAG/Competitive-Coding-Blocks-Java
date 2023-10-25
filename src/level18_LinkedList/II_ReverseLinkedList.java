/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 31-01-2022/01/2022
 *   Time: 06:44 PM
 *   File: II_ReverseLinkedList
 */

/**
 * LEETCODE QUESTION 206 =>
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */

package level18_LinkedList;

public class II_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;

            while (current != null) {
                ListNode ahead = current.next;
                current.next = prev;
                prev = current;
                current = ahead;
            }
            return prev;
        }
    }
}
