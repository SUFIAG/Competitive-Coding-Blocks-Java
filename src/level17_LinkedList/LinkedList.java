/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D-Coder135)
 *   Date: 31-01-2022/01/2022
 *   Time: 12:15 PM
 *   File: LinkedList
 */

package level17_LinkedList;

public class LinkedList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
    }

    private Node head;
    private int size;
    private Node tail;

    // Add Methods
    public void addFirst(int item) {
        Node newNode = new Node(item);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int item) {
        if (this.size == 0) {
            addFirst(item);
        } else {
            Node newNode = new Node(item);
            this.tail.next = newNode;
            this.tail = newNode;
            this.size++;
        }
    }

    public void addAtIndex(int index, int item) throws Exception {
        if (index < 0 || index > this.size) {
            throw new Exception("Index not within the range.");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == this.size) {
            addLast(item);
        } else {
            Node newNode = new Node(item);
            Node previousNode = getNode(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            this.size++;
        }
    }

    public int getFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List Is Empty!");
        }
        return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List Is Empty!");
        }
        return this.tail.data;
    }

    public int getAnyIndex(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List Is Empty!");
        }
        return getNode(index).data;
    }


    private Node getNode(int k) throws Exception {
        if (k < 0 || k >= this.size) {
            throw new Exception("Index not within the range.");
        }
        Node temp = this.head;

        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Remove methods
    public int removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List Is Empty!");
        }
        int data = this.head.data;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node temp = this.head;
            this.head = this.head.next;
            temp.next = null;
        }
        this.size--;
        return data;
    }

    public int removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List Is Empty!");
        }
        if (this.size == 1) {
            return removeFirst();
        }

        int data = this.tail.data;

        Node prevNode = getNode(this.size - 2);
        prevNode.next = null;
        this.tail = prevNode;
        this.size--;
        return data;
    }

    public int removeAtIndex(int index) throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List Is Empty!");
        }
        if (index < 0 || index >= this.size) {
            throw new Exception("Index not within range.");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node prevNode = getNode(index - 1);
            Node node = prevNode.next;
            prevNode.next = node.next;
            node.next = null;
            this.size--;
            return node.data;
        }
    }

    public void display() {

        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println(".");

    }
}
