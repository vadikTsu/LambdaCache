package ua.com.foxminded.service;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniqueSumbolCounterTest {

    private CharCounter characterCounter;

    @BeforeEach
    void beforeEach() {
        characterCounter = new UniqueCharCounter();
    }

    @Test
    void countChars_shouldReturnMapOpjectWithCharOccurnce_WhenRegularStringQuery() {
        String text = "hello world";

        Map<Character, Integer> actual = characterCounter.countChars(text);
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
    void countChars_shouldReturnMapOpjectWithCharOccurnce_WhenWhiteSpacesStringQuery() {
        String query = "     ";

        Map<Character, Integer> actual = characterCounter.countChars(query);
        Map<Character, Integer> expected = new HashMap<>();

        expected.put(' ', 5);

        assertEquals(expected, actual);
    }

    @Test
    void countChars_shouldReturnMapOpjectWithCharOccurnce_WhenNonAlphabeticStringQuery() {
        String text = "!@#$%^*(";

        Map<Character, Integer> actual = characterCounter.countChars(text);
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
    void countChars_shouldReturnEmplyMapOpject_WhenBlankStringQuery() {
        String text = "";

        Map<Character, Integer> charCounts = characterCounter.countChars(text);

        assertTrue(charCounts.isEmpty());
    }

}
