package app.tasks;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    Node head;


    class Node {
        int value;
        Node next;

        Node(int d) {
            value = d;
        }

    }

    public void add(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            return;
        }
        Node end = new Node(value);
        Node n = this.head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public int size() {
        int count = 0;
        if (head != null) {
            count = 1;
            Node current = head;
            while (current.next != null) {
                current = current.next;
                count++;
            }
        }
        return count;
    }


    /**
     * this function removes duplicates from an unordered singly linked list
     */
    public void removeDups() {
        Node ptr1, ptr2, dup = null;
        ptr1 = head;

        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.value == ptr2.next.value) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
}
