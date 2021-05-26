package tests;

import app.tasks.Tasks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    Tasks tasks;

    @Test
    @BeforeEach
    void setUp() {
        tasks = new Tasks();
    }

    @Test
    @Order(1)
    void isUnique_emptyStringAsInput_returnsTrue() {
        assertTrue(tasks.isUnique(""));
    }

    @Test
    @Order(2)
    void isUnique_OneCharacterAsInput_returnsTrue() {
        assertTrue(tasks.isUnique("d"));
    }

    @Test
    @Order(3)
    void isUnique_wordWithUniqueLettersAsInput_returnsTrue() {
        assertTrue(tasks.isUnique("dermatoglyphics"));
    }

    @Test
    @Order(4)
    void isUnique_wordWithRepeatingLettersAsInput_returnsFalse() {
        assertFalse(tasks.isUnique("pizza"));
    }
}