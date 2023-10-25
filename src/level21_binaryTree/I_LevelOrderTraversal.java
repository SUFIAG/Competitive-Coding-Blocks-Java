/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 09-02-2022/02/2022
 *   Time: 12:10 PM
 *   File: I_LevelOrderTraversal
 */

package level21_binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class I_LevelOrderTraversal {

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

    public I_LevelOrderTraversal() {
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

    // For Level Order traversal, always use Queue.
    public void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node removeNode = queue.remove();
            System.out.println(removeNode.data + " ");

            if (removeNode.left != null) {
                queue.add(removeNode.left);
            }

            if (removeNode.right != null) {
                queue.add(removeNode.right);
            }
        }
        System.out.println();
    }
}
