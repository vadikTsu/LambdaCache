package ua.com.foxminded.service;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniqueSumbolCounterCasheTest {

    private CharCounter charCounter;

    @BeforeEach
    void setUp() {
        charCounter = new UniqueSymbolOccuranceCashe(new UniqueSymbolCounter());
    }

    @Test
    void testConstructor_shouldReturnNullPointerException_NullInput() {
        Assertions.assertThrows(NullPointerException.class, () -> new UniqueSymbolOccuranceCashe(null));
    }

    @Test
    void countChars_shouldReturnEmplyMapObject_WhenBlankStringQuery() {
        String text = "";

        Map<Character, Integer> expected = charCounter.countChars(text);
        
        Assertions.assertTrue(expected.isEmpty());
    }

    @Test
    void countChars_shouldReturnNullPointerException_WhenNullQuery() {

        Assertions.assertThrows(NullPointerException.class, () -> charCounter.countChars(null));
    }
}

