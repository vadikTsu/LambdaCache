package ua.com.foxminded.service;

import java.util.Map;

/**
 * The CharOperator interface defines a contract for classes that perform
 * character counting operations on a given query string.
 */
public interface CharCounter {

    /**
     * Counts the occurrences of each character in the input query string.
     *
     * @param text the input string to be processed.
     * @return a Map containing each unique character as keys and their respective
     *         counts as values.
     */
    Map<Character, Integer> countChars(String text);
}
