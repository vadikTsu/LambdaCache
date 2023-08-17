package ua.com.foxminded.service;

import java.util.HashMap;

import java.util.Map;

/**
 * CharCounterCache is a class that implements the CharCounter interface as a
 * decorator for the UniqueCharCounter class. It provides caching functionality
 * to avoid redundant calculations when counting character occurrences.
 */
public class CharCounterCache implements CharCounter {

    private CharCounter charCounter;
    private Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public CharCounterCache(CharCounter charCounter) {
        this.charCounter = charCounter;
    }

    /**
     * Counts the occurrences of each character in the input text string. If the
     * text has been processed before, the result is retrieved from the cache to
     * avoid redundant calculations.
     *
     * @param text the input string to be processed.
     * @return a Map containing each unique character as keys and their respective
     *         counts as values.
     */
    @Override
    public Map<Character, Integer> countChars(String text) {
        cache.putIfAbsent(text, charCounter.countChars(text));
        return cache.get(text);

    }

}
