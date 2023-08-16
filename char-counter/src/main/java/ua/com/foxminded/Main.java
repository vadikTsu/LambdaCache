/* Client is a simple Java class that demonstrates the usage of the
 * CharCounter application to count character occurrences in multiple input
 * query strings.
 */
package ua.com.foxminded;

import ua.com.foxminded.service.UniqueSymbolOccuranceCashe;
import ua.com.foxminded.service.CharCounter;
import ua.com.foxminded.service.UniqueSymbolCounter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CharCounter charCounter = new UniqueSymbolOccuranceCashe(new UniqueSymbolCounter());
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String text = scanner.nextLine();
                if (text.isEmpty()) {  
                    break;
                }
                charCounter.countChars(text).forEach((key, value) -> System.out.println(key + " :: " + value));
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}
