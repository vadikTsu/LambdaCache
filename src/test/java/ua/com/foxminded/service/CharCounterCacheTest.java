package ua.com.foxminded.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ua.com.foxminded.charcounter.CharCounter;
import ua.com.foxminded.charcounter.CharCounterCache;

@ExtendWith(MockitoExtension.class)
class CharCounterCacheTest {

    @Mock
    private CharCounter charCounter;

    @InjectMocks
    private CharCounterCache charCounterCache;

    @Test
    void countChars_shouldRetrieveFromCache_WhenSameText() {
        String text = "abc";

        Map<Character, Integer> mockResult = new HashMap<>();
        mockResult.put('a', 1);
        mockResult.put('b', 1);
        mockResult.put('c', 1);
        when(charCounter.countChars(text)).thenReturn(mockResult);

        Map<Character, Integer> result1 = charCounterCache.countChars(text);

        Map<Character, Integer> result2 = charCounterCache.countChars(text);

        verify(charCounter, times(1)).countChars(text);
        assertEquals(result1, result2);
    }

    @Test
    void testCountChars_shouldNotRetriveFromCache_WhenDifferentText() {
        String text1 = "abc";
        String text2 = "   ";

        Map<Character, Integer> mockResult1 = new HashMap<>();
        mockResult1.put('a', 1);
        mockResult1.put('b', 1);
        mockResult1.put('c', 1);

        Map<Character, Integer> mockResult2 = new HashMap<>();
        mockResult2.put(' ', 3);

        when(charCounter.countChars(text1)).thenReturn(mockResult1);
        when(charCounter.countChars(text2)).thenReturn(mockResult2);

        Map<Character, Integer> result1 = charCounterCache.countChars(text1);
        Map<Character, Integer> result2 = charCounterCache.countChars(text2);

        verify(charCounter, times(1)).countChars(text1);
        verify(charCounter, times(1)).countChars(text2);

        assertEquals(result1, charCounterCache.countChars(text1));
        assertEquals(result2, charCounterCache.countChars(text2));
    }
}
