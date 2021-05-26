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

    @Test
    @Order(5)
    void permutation_twoEmptyStringsAsInputs_returnsTrue() {
        assertTrue(tasks.permutation("", ""));
    }

    @Test
    @Order(6)
    void permutation_oneEmptyStringAndOneNotEmptyAsInputs_returnsFalse() {
        assertFalse(tasks.permutation("", "F"));
    }

    @Test
    @Order(7)
    void permutation_permutationInputs_returnsTrue() {
        assertTrue(tasks.permutation("KRETCCI", "CRICKET"));
    }

    @Test
    @Order(8)
    void permutation_inputsWithOneLetterOff_returnsFalse() {
        assertFalse(tasks.permutation("KRETCGI", "CRICKET"));
    }
}