/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 09-02-2022/02/2022
 *   Time: 06:30 PM
 *   File: II_LevelOrderLineWise
 */

/**
 * LEETCODE QUESTION 102 =>
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
 * level by level).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 */

package level21_binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class II_LevelOrderLineWise {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
    }

    private final Node root;
    Scanner scanner = new Scanner(System.in);

    public II_LevelOrderLineWise(Node root) {
        this.root = createTree();
    }

    private Node createTree() {
        int item = scanner.nextInt();
        Node newNode = new Node(item);
        boolean hasLeftChild = scanner.nextBoolean();

        if (hasLeftChild) {
            newNode.left = createTree();
        }

        boolean hasRightChild = scanner.nextBoolean();

        if (hasRightChild) {
            newNode.right = createTree();
        }
        return newNode;
    }

    public void leveOrderLineWise() {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> helperQueue = new LinkedList<>();

        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node removedNode = queue.remove();
            System.out.print(removedNode.data + " ");

            if (removedNode.left != null) {
                helperQueue.add(removedNode.left);
            }

            if (removedNode.right != null) {
                helperQueue.add(removedNode.right);
            }

            if (queue.isEmpty()) {
                queue = helperQueue;
                helperQueue = new LinkedList<>();
                System.out.println();
            }
        }
    }

    /*
     * LEETCODE SOLUTION =>
     *
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> helper = new LinkedList<>();

            if(root == null) return result;

            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode removedNode = queue.remove();
                list.add(removedNode.val);

                if(removedNode.left != null) {
                    helper.add(removedNode.left);
                }

                if(removedNode.right != null) {
                    helper.add(removedNode.right);
                }

                if(queue.isEmpty()) {
                    result.add(list);
                    list = new ArrayList<>();
                    queue = helper;
                    helper = new LinkedList<>();
                }
            }
            return result;
        }
    }
    *
    * */
}
