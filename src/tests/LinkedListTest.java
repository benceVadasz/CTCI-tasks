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
}