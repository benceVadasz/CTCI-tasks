package tests;

import app.tasks.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<T> {

    LinkedList<Integer> integerList;
    LinkedList<String> stringList;

    @Test
    @BeforeEach
    void setUp() {
        integerList = new LinkedList<>();
        stringList = new LinkedList<>();
    }

    @Test
    @Order(1)
    void add_singleElementToEmptyList_increaseSizeByOne() {
        integerList.add(123);
        assertEquals(1, integerList.size());
    }

    @Test
    @Order(2)
    void removeDups_returnsWithDuplicatesRemoved() {
        integerList.add(123);
        integerList.add(123);
        integerList.add(123);
        integerList.add(7);
        integerList.removeDups();
        assertEquals(2, integerList.size());
    }

    @Test
    @Order(3)
    void deleteMiddleNode_linkedListWithOnlyHead_returnsEmptyList() {
        integerList.add(123);
        integerList.deleteMiddleNode();
        assertEquals(0, integerList.size());
    }

    @Test
    @Order(4)
    void deleteMiddleNode_afterFunctionLinkedListWithThreeNodes_returnsWithTwo() {
        integerList.add(7);
        integerList.add(123);
        integerList.add(77);
        integerList.deleteMiddleNode();
        assertEquals(2, integerList.size());
    }

    @Test
    @Order(5)
    void deleteMiddleNode_afterFunctionLinkedListWithFourNodes_returnsWithThree() {
        integerList.add(7);
        integerList.add(123);
        integerList.add(77);
        integerList.add(77);
        integerList.deleteMiddleNode();
        assertEquals(3, integerList.size());
    }

    @Test
    @Order(6)
    void partition_returnsLinkedListOrdered() {
        integerList.add(1);
        integerList.add(4);
        integerList.add(3);
        integerList.add(2);
        integerList.add(5);
        integerList.add(2);
        integerList = integerList.partition(3);
        assertEquals(2, integerList.get(1));
        assertEquals(2, integerList.get(2));
        assertEquals(4, integerList.get(3));
        assertEquals(3, integerList.get(4));
        assertEquals(5, integerList.get(5));
    }

    @Test
    @Order(7)
    void sumLists_addsTwoNumbersRepresentedAsLinkedLists_returnsLinkedListOfSum() {
        LinkedList<Integer> llTwo = new LinkedList<>();
        integerList.add(7);
        integerList.add(1);
        integerList.add(6);
        llTwo.add(5);
        llTwo.add(9);
        llTwo.add(2);

        assertEquals(2, integerList.sumLists(integerList, llTwo));
    }

    @Test
    @Order(8)
    void palindrome_listWithOneNode_returnsTrue() {
        stringList.add("d");
        assertTrue(stringList.palindrome(stringList, stringList.getHead()));
    }

    @Test
    @Order(8)
    void palindrome_listWithPalindrome_returnsTrue() {
        stringList.add("b");
        stringList.add("o");
        stringList.add("b");
        assertTrue(stringList.palindrome(stringList, stringList.getHead()));
    }

    @Test
    @Order(9)
    void palindrome_listWithNoPalindrome_returnsFalse() {
        stringList.add("b");
        stringList.add("u");
        stringList.add("r");
        stringList.add("g");
        stringList.add("i");
        stringList.add("r");
        assertFalse(stringList.palindrome(stringList, stringList.getHead()));
    }

    @Test
    @Order(10)
    void palindrome_longPalindrome_returnsTrue() {
        stringList.add("s");
        stringList.add("u");
        stringList.add("r");
        stringList.add("g");
        stringList.add("i");
        stringList.add("g");
        stringList.add("r");
        stringList.add("u");
        stringList.add("s");
        assertTrue(stringList.palindrome(stringList, stringList.getHead()));
    }

    @Test
    @Order(11)
    void intersection_twoListsWithNoIntersection_returnsNull() {
        LinkedList<String> llTwo = new LinkedList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        llTwo.add("D");
        llTwo.add("E");
        llTwo.add("F");
        assertNull(stringList.intersection(stringList, llTwo));
    }

    @Test
    @Order(11)
    void intersection_twoListsWithIntersection_returnsValue() {
        LinkedList<Integer> llTwo = new LinkedList<>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(7);
        integerList.add(1);
        llTwo.add(3);
        llTwo.add(7);
        llTwo.add(8);
        assertEquals(7, integerList.intersection(integerList, llTwo));
    }

    @Test
    @Order(12)
    void intersection_twoListsWithSameLengthAndIntersection_returnsValue() {
        LinkedList<String> llTwo = new LinkedList<>();
        stringList.add("B");
        stringList.add("A");
        stringList.add("F");
        llTwo.add("A");
        llTwo.add("B");
        llTwo.add("C");
        assertEquals("A", stringList.intersection(stringList, llTwo));
    }
}