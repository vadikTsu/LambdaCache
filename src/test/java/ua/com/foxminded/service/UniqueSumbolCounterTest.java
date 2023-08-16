package ua.com.foxminded.service;


import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UniqueSumbolCounterTest {

    private CharCounter characterCounter;
    private Map<Character, Integer> expected;
    
    @BeforeEach
    void beforeEach() {
        characterCounter = new UniqueSymbolCounter();
        expected = new HashMap<>();
    }

    @Test
    void countChars_shouldReturnMapOpjectWithCharOccurnce_WhenRegularStringQuery() {
        String text = "hello world";

        Map<Character, Integer> actual = characterCounter.countChars(text);
        
        expected.put('l', 3);
        expected.put('e', 1);
        expected.put(' ', 1);
        expected.put('h', 1);
        expected.put('o', 2);
        expected.put('w', 1);
        expected.put('r', 1);
        expected.put('d', 1);

        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void countChars_shouldReturnMapOpjectWithCharOccurnce_WhenWhiteSpacesStringQuery() {
        String query = "     ";
        
        Map<Character, Integer> actual = characterCounter.countChars(query);
        expected.put(' ', 5);

        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void countChars_shouldReturnMapOpjectWithCharOccurnce_WhenNonAlphabeticStringQuery() {
        String text = "!@#$%^*(";
        
        Map<Character, Integer> actual = characterCounter.countChars(text);
        
        expected.put('!', 1);
        expected.put('@', 1);
        expected.put('#', 1);
        expected.put('$', 1); 
        expected.put('%', 1);
        expected.put('^', 1);
        expected.put('*', 1);
        expected.put('(', 1);
        
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countChars_shouldReturnEmplyMapOpject_WhenBlankStringQuery() {
        String text = "";

        Map<Character, Integer> charCounts = characterCounter.countChars(text);

        Assertions.assertTrue(charCounts.isEmpty());
    }

}
