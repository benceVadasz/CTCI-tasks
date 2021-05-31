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
    void permutation_inputWithOneLetterOff_returnsFalse() {
        assertFalse(tasks.permutation("KRETCGI", "CRICKET"));
    }

    @Test
    @Order(9)
    void urlIfy_stringInputWithSpacesAndLength_returnsCorrectUrl() {
        assertEquals("Mr%20John%20Smith", tasks.urlIfy("Mr John Smith      ", 13));
    }

    @Test
    @Order(10)
    void oneWay_inputWithOneLetterOffAndDifferentLength_returnsTrue() {
        assertTrue(tasks.oneEditAway("pale", "ple"));
    }

    @Test
    @Order(11)
    void oneWay_inputWithDifferentLength_returnsTrue() {
        assertTrue(tasks.oneEditAway("pale", "pales"));
    }

    @Test
    @Order(12)
    void oneWay_inputWithSameLengthAndOneLetterOff_returnsTrue() {
        assertTrue(tasks.oneEditAway("pale", "bale"));
    }

    @Test
    @Order(13)
    void oneWay_inputWithSameLengthAndTwoLettersOff_returnsFalse() {
        assertFalse(tasks.oneEditAway("pale", "bake"));
    }

    @Test
    @Order(14)
    void compression_shortInput_returnsTheString() {
        assertEquals("abcdefg", tasks.compression("abcdefg"));
    }

    @Test
    @Order(15)
    void compression_inputWithMultipleDuplicates_returnsCompression() {
        assertEquals("a2b1c5a3", tasks.compression("aabcccccaaa"));
    }

    @Test
    @Order(16)
    void rotateMatrix_methodRotatesMatrix() {
        int[][] result = { {3,6,9} , {2,5,8}, {1,4,7} };
        int[][] input = { {1,2,3} , {4,5,6}, {7,8,9} };
        assertArrayEquals(result, tasks.rotateMatrix(input));
    }

    @Test
    @Order(17)
    void zeroMatrix_matrixWithNoZeros_returnsOriginalMatrix() {
        int[][] input = { {3,6,9} , {2,5,8}, {1,4,7} };
        assertArrayEquals(input, tasks.zeroMatrix(input));
    }

    @Test
    @Order(18)
    void zeroMatrix_MatrixWithOneZero_returnsItsRowAndColumnWithZeros() {
        int[][] input = { {3,0,9} , {2,5,8}, {1,4,7} };
        int[][] result = { {0,0,0} , {2,0,8}, {1,0,7} };
        assertArrayEquals(result, tasks.zeroMatrix(input));
    }

    @Test
    @Order(19)
    void zeroMatrix_MatrixWithZerosInEveryRow_returnsAllZeros() {
        int[][] input = { {3,0,9} , {0,5,8}, {1,4,0} };
        int[][] result = { {0,0,0} , {0,0,0}, {0,0,0} };
        assertArrayEquals(result, tasks.zeroMatrix(input));
    }
}