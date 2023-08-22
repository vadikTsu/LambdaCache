package ua.com.foxminded.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.charcounter.UniqueCharCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCharCounterTest {

    private UniqueCharCounter charCounter;

    @BeforeEach
    void beforeEach() {
        charCounter = new UniqueCharCounter();
    }

    @Test
    void countChars_shouldReturnUniqueCharOccurnceCollectedToHashMap_WhenRegularStringText() {
        String text = "hello world";

        Map<Character, Integer> actual = charCounter.countChars(text);
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('l', 3);
        expected.put('e', 1);
        expected.put(' ', 1);
        expected.put('h', 1);
        expected.put('o', 2);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);

        assertEquals(expected, actual);
    }

    @Test
    void countChars_shouldReturnUniqueCharOccurnceCollectedToHashMap_WhenWhiteSpacesStringText() {
        String query = "     ";

        Map<Character, Integer> actual = charCounter.countChars(query);
        Map<Character, Integer> expected = new HashMap<>();

        expected.put(' ', 5);

        assertEquals(expected, actual);
    }

    @Test
    void countChars_shouldReturnUniqueCharOccurnceCollectedToHashMap_WhenNonAlphabeticStringText() {
        String text = "!@#$%^*(";

        Map<Character, Integer> actual = charCounter.countChars(text);
        Map<Character, Integer> expected = new HashMap<>();

        expected.put('!', 1);
        expected.put('@', 1);
        expected.put('#', 1);
        expected.put('$', 1);
        expected.put('%', 1);
        expected.put('^', 1);
        expected.put('*', 1);
        expected.put('(', 1);

        assertEquals(expected, actual);
    }

    @Test
    void countChars_shouldReturnUniqueCharOccurnceCollectedToHashMap_WhenUpperAndLowerCaseStringText() {
        String text = "AaaBbbCCcc";

        Map<Character, Integer> actual = charCounter.countChars(text);
        Map<Character, Integer> expected = new HashMap<>();

        expected.put('A', 1);
        expected.put('B', 1);
        expected.put('C', 2);
        expected.put('a', 2);
        expected.put('b', 2);
        expected.put('c', 2);

        assertEquals(expected, actual);
    }

    @Test
    void countChars_shouldReturnEmplyHashMapObject_WhenBlankStringText() {
        String text = "";

        Map<Character, Integer> charCounts = charCounter.countChars(text);

        assertEquals(charCounts, Collections.emptyMap());
    }

}
