/* Main is a simple Java class that demonstrates the usage of the
 * CharCounter application to count character occurrences in multiple input
 * query strings.
 */
package ua.com.foxminded;

import java.util.Scanner;

import ua.com.foxminded.charcounter.CharCounter;
import ua.com.foxminded.charcounter.CharCounterCache;
import ua.com.foxminded.charcounter.UniqueCharCounter;

public class Main {

    public static void main(String[] args) {
        CharCounter charCounter = new CharCounterCache(new UniqueCharCounter());
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            while (!text.isEmpty()) {
                charCounter.countChars(text).forEach((key, value) -> System.out.println(key + " :: " + value));
                text = scanner.nextLine();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
