package app.tasks;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
}
