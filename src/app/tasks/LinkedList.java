package app.tasks;

import jdk.dynalink.NamedOperation;

import java.util.ArrayList;
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

    public int get(int index) {
        if (0 > index) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node current = head;
        while (current != null) {
            if (i == index) {
                return current.value;
            }
            current = current.next;
            i++;
        }

        throw new IndexOutOfBoundsException();
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

    public void deleteMiddleNode() {
        if (head == null)
            return;
        if (head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            prev = slow;
        }
        prev.next = slow.next;
    }

    public LinkedList partition(int value) {
        LinkedList less = new LinkedList();
        LinkedList equalOrMore = new LinkedList();

        Node current = head;
        while (current != null) {
            if (current.value < value) {
                less.add(current.value);
            } else {
                equalOrMore.add(current.value);
            }
            current = current.next;
        }
        Node equalOrMoreCurrent = equalOrMore.head;
        while (equalOrMoreCurrent.next != null) {
            less.add(equalOrMoreCurrent.value);
            equalOrMoreCurrent = equalOrMoreCurrent.next;
        }
        less.add(equalOrMoreCurrent.value);
        return less;
    }

    public int sumLists(LinkedList first, LinkedList second) {
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        Node currF = first.head;
        Node currS = second.head;
        while (currF != null || currS != null || carry == 1) {
            int sum = 0;
            if (currF != null) {
               sum += currF.value;
               currF = currF.next;
            }
            if (currS != null) {
               sum += currS.value;
               currS = currS.next;
            }

            sum += carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return dummy.next.value;
    }
}
