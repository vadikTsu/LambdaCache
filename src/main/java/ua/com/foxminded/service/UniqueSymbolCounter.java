package ua.com.foxminded.service;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * UniqueSymbolCounter is a class that implements the CharOperator interface. It
 * provides functionality to count the occurrences of each character in a given
 * query string.
 */
public class UniqueSymbolCounter implements CharCounter {

    /**
     * Counts the occurrences of each character in the input text string.
     *
     * @param text the input string to be processed.
     * @return a Map containing each unique character as keys and their respective
     *         counts as values.
     */
    @Override
    public Map<Character, Integer> countChars(String text) {
        return text.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.summingInt(ch -> 1)));
    }
}
