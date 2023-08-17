package ua.com.foxminded.service;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniqueSumbolCounterCasheTest {

    private CharCounter charCounter;

    @BeforeEach
    void setUp() {
        charCounter = new CharCounterCache(new UniqueCharCounter());
    }

    @Test
    void testConstructor_shouldReturnNullPointerException_NullInput() {
        assertThrows(NullPointerException.class, () -> new CharCounterCache(null));
    }

    @Test
    void countChars_shouldReturnEmplyMapObject_WhenBlankStringQuery() {
        String text = "";

        Map<Character, Integer> expected = charCounter.countChars(text);

        assertTrue(expected.isEmpty());
    }

    @Test
    void countChars_shouldReturnNullPointerException_WhenNullQuery() {
        assertThrows(NullPointerException.class, () -> charCounter.countChars(null));
    }
}
