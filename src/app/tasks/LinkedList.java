package app.tasks;

import java.util.ArrayList;

public class LinkedList<T> {
    Node<T> head;


    class Node<T> {
        private final T value;
        Node<T> next;

        Node(T d) {
            value = d;
            this.next = null;
        }

    }

    public void add(T value) {
        if (this.head == null) {
            this.head = new Node<>(value);
        } else {
            Node<T> end = new Node<>(value);
            Node<T> n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }

    public int size() {
        int count = 0;
        if (head != null) {
            count = 1;
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
                count++;
            }
        }
        return count;
    }

    public T get(int index) {
        if (0 > index) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node<T> current = head;
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
        Node<T> ptr1, ptr2, dup = null;
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
            head = null;
            return;
        }
        Node<T> slow = head;
        Node<T> fast = head;
        Node<T> prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;

        }
        prev.next = slow.next;
    }

    public LinkedList<T> partition(int value) {
        LinkedList<T> less = new LinkedList<>();
        LinkedList<T> equalOrMore = new LinkedList<>();

        Node<T> current = head;
        while (current != null) {
            if ((int) current.value < value) {
                less.add(current.value);
            } else {
                equalOrMore.add(current.value);
            }
            current = current.next;
        }
        Node<T> equalOrMoreCurrent = equalOrMore.head;
        while (equalOrMoreCurrent.next != null) {
            less.add((T) equalOrMoreCurrent.value);
            equalOrMoreCurrent = equalOrMoreCurrent.next;
        }
        less.add((T) equalOrMoreCurrent.value);
        return less;
    }

    public int sumLists(LinkedList<T> first, LinkedList<T> second) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> temp = dummy;
        int carry = 0;
        Node<T> currF = first.head;
        Node<T> currS = second.head;
        while (currF != null || currS != null || carry == 1) {
            int sum = 0;
            if (currF != null) {
                sum += (int) currF.value;
                currF = currF.next;
            }
            if (currS != null) {
                sum += (int) currS.value;
                currS = currS.next;
            }

            sum += carry;
            carry = sum / 10;
            temp.next = new Node<>(sum % 10);
            temp = temp.next;
        }
        return dummy.next.value;
    }

    public boolean palindrome(LinkedList<T> nodeWrapper, Node<T> head) {
        return checkPalindrome(nodeWrapper, head);
    }

    public boolean checkPalindrome(LinkedList<T> left, Node<T> right) {
        if (right == null) {
            return true;
        }
        boolean result = checkPalindrome(left, right.next) &&
                (left.head.value == right.value);
        left.head = left.head.next;

        return result;
    }

    public Node<T> getHead() {
        return head;
    }

    public T intersection(LinkedList<T> aL, LinkedList<T> bL)
    {
        Node<T> headA = aL.head;
        Node<T> headB = bL.head;
        Node<T> a = headA, b = headB;
        while (a != b) {
            a = a.next == null ? headB : a.next;
            if (a.value == b.value) return a.value;
            b = b.next == null ? headA : b.next;
        }
        return a != null ? a.value : null;
    }
}
