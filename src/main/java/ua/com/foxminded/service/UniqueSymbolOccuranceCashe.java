package ua.com.foxminded.service;

import java.util.HashMap;
import java.util.Map;

/**
 * UniqueSymbolOccuranceCashe is a class that implements the CharOperator interface as a
 * decorator for the CharCounter class. It provides caching functionality to
 * avoid redundant calculations when counting character occurrences.
 */
public class UniqueSymbolOccuranceCashe implements CharCounter {

    private CharCounter charCounter;
    private Map<String, Map<Character, Integer>> cashe = new HashMap<>();;

    public UniqueSymbolOccuranceCashe(CharCounter charCounter) {
        this.charCounter = charCounter; 
    }

    /**
     * Counts the occurrences of each character in the input text string. If the
     * query has been processed before, the result is retrieved from the cache to
     * avoid redundant calculations.
     *
     * @param text the input string to be processed.
     * @return a Map containing each unique character as keys and their respective
     *         counts as values.
     */
    @Override
    public Map<Character, Integer> countChars(String text) {
        Map<Character, Integer> cashed = cashe.get(text);
        if (cashed.isEmpty()) {
            cashed = charCounter.countChars(text);
            cashe.put(text, cashed);
        } else {
            System.out.println("Retrieved '" + text + "' from cache.");
        }
        return cashed;
    }

}
