package tests;

import app.tasks.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList ll;

    @Test
    @BeforeEach
    void setUp() {
        ll = new LinkedList();
    }

    @Test
    @Order(1)
    void add_singleElementToEmptyList_increaseSizeByOne() {
        ll.add(123);
        assertEquals(1, ll.size());
    }

    @Test
    @Order(2)
    void removeDups_returnsWithDuplicatesRemoved() {
        ll.add(123);
        ll.add(123);
        ll.add(123);
        ll.add(7);
        ll.removeDups();
        assertEquals(2, ll.size());
    }

    @Test
    @Order(3)
    void deleteMiddleNode_linkedListWithOnlyHead_returnsEmptyList() {
        ll.add(123);
        ll.deleteMiddleNode();
        assertEquals(0, ll.size());
    }

    @Test
    @Order(4)
    void deleteMiddleNode_afterFunctionLinkedListWithThreeNodes_returnsWithTwo() {
        ll.add(7);
        ll.add(123);
        ll.add(77);
        ll.deleteMiddleNode();
        assertEquals(2, ll.size());
    }

    @Test
    @Order(5)
    void deleteMiddleNode_afterFunctionLinkedListWithFourNodes_returnsWithThree() {
        ll.add(7);
        ll.add(123);
        ll.add(77);
        ll.add(77);
        ll.deleteMiddleNode();
        assertEquals(3, ll.size());
    }

    @Test
    @Order(6)
    void partition_returnsLinkedListOrdered() {
        ll.add(1);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(5);
        ll.add(2);
        ll = ll.partition(3);
        assertEquals(2, ll.get(1));
        assertEquals(2, ll.get(2));
        assertEquals(4, ll.get(3));
        assertEquals(3, ll.get(4));
        assertEquals(5, ll.get(5));
    }

    @Test
    @Order(7)
    void sumLists_addsTwoNumbersRepresentedAsLinkedLists_returnsLinkedListOfSum() {
        LinkedList llTwo = new LinkedList();
        ll.add(7);
        ll.add(1);
        ll.add(6);
        llTwo.add(5);
        llTwo.add(9);
        llTwo.add(2);

        assertEquals(2, ll.sumLists(ll, llTwo));
    }
}