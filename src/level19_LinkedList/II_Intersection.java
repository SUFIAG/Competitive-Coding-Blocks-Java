/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 01-02-2022/02/2022
 *   Time: 07:07 PM
 *   File: II_Intersection
 */

/**
 * LEETCODE QUESTION 160 =>
 * <p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the function returns.
 * <p>
 * Custom Judge:
 * <p>
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * <p>
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to
 * your program. If you correctly return the intersected node, then your solution will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before
 * the intersected node in A; There are 3 nodes before the intersected node in B.
 */

package level19_LinkedList;

public class II_Intersection {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;
                }

                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;
                }
            }
            return a;
        }
    }
}
