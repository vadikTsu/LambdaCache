package ua.com.foxminded.service;

import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * UniqueSymbolCounter is a class that implements the CharCounter interface. It
 * provides functionality to count the occurrences of each character in a given
 * query string.
 */
public class UniqueCharCounter implements CharCounter {

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
                .collect(groupingBy(ch -> ch, summingInt(ch -> 1)));
    }
}
