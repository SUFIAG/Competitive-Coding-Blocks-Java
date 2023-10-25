/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 07-02-2022/02/2022
 *   Time: 10:21 PM
 *   File: BinaryTree
 */

package level20_binaryTree;

import java.util.Scanner;

public class BinaryTree {
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

    Scanner scanner = new Scanner(System.in);
    private final Node root;

    public BinaryTree() {
        this.root = createTree(null);
    }

    private Node createTree(Node parentNode) {
        int item = scanner.nextInt();
        Node newNode = new Node(item);
        boolean hasLeftChild = scanner.nextBoolean();

        if (hasLeftChild) {
            newNode.left = createTree(newNode);
        }

        boolean hasRightChild = scanner.nextBoolean();

        if (hasRightChild) {
            newNode.right = createTree(newNode);
        }
        return newNode;
    }

    public void displayTree() {
        displayTree(this.root);
    }

    private void displayTree(Node node) {
        if (node == null) {
            return;
        }

        String str = "" + node.data;
        str = "<---" + str;

        if (node.left != null) {
            str = node.left.data + str;
        } else {
            str = "." + str;
        }

        str = str + "--->";

        if (node.right != null) {
            str = node.right.data + str;
        } else {
            str = str + ".";
        }
        System.out.println(str);
        displayTree(node.left);
        displayTree(node.right);
    }


    public boolean find(int item) {
        return find(this.root, item);
    }

    private boolean find(Node node, int item) {
        if (node == null) {
            return false;
        }
        if (node.data == item) {
            return true;
        }
        boolean left = find(node.left, item);
        boolean right = find(node.right, item);

        return left || right;
    }

    public int min() {
        return min(this.root);
    }

    private int min(Node node) {

        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int selfMin = node.data;
        int leftMin = min(node.left);
        int rightMin = min(node.right);

        return Math.min(selfMin, Math.min(leftMin, rightMin));
    }

    public int max() {
        return max(this.root);
    }

    private int max(Node node) {

        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int selfMax = node.data;
        int leftMax = min(node.left);
        int rightMax = min(node.right);

        return Math.min(selfMax, Math.min(leftMax, rightMax));
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node node) {

        if (node == null) {
            return 0;
        }

        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {

        // Considering height of a single node is 0.
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return leftHeight + rightHeight + 1;
    }

    public void preOrder() {
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data + " ");
    }

    public void inOrder() {
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        System.out.println(node.data + " ");
        postOrder(node.right);
    }
}
