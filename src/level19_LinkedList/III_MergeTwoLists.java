/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 01-02-2022/02/2022
 *   Time: 07:42 PM
 *   File: III_MergeTwoLists
 */

/**
 * LEETCODE QUESTION 21 =>
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two
 * lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * Example 1:
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 */

package level19_LinkedList;

public class III_MergeTwoLists {
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

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode temp = new ListNode();
            ListNode ans = temp;

            while (list1 != null && list2 != null) {

                if (list1.val <= list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }

            if (list1 != null) {
                temp.next = list1;
            }
            if (list2 != null) {
                temp.next = list2;
            }

            return ans.next;
        }
    }
}
