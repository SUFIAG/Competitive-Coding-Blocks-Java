/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 09-02-2022/02/2022
 *   Time: 10:38 PM
 *   File: III_DiameterOfBinaryTree
 */

/**
 * LEETCODE QUESTION 543 =>
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may
 * or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * <p>
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2]
 * Output: 1
 */

package level21_binaryTree;

public class III_DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int leftDiameter = diameterOfBinaryTree(root.left);
            int rightDiameter = diameterOfBinaryTree(root.right);
            int selfDiameter = height(root.left) + height(root.right) + 2;

            return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
        }

        public int height(TreeNode root) {
            if (root == null) {
                return -1;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
