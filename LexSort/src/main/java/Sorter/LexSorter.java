package Sorter;
import lists.*;
import ArrayList.*;

/**
 * Created by farkh on 29/02/16.
 */
public class LexSorter {
    public LinkedList<String> sort(LinkedList<String> list) {
        int maxLength;

        Element<String> element = list.getFirst();
        maxLength = element.getValue().split(" ", 1)[0].length();
        while (element.getValue() != null) {
            if (element.getValue().split(" ", 1)[0].length() > maxLength) {
                maxLength = element.getValue().split(" ", 1)[0].length();
            }
            element = element.getNext();
        }

        for (int i = 0; i < maxLength; i++) {
            list = sortWords(list, i);
        }
        return list;
    }

    public LinkedList<String> sortWords(LinkedList<String> list, int i) {
        ArrayList<LinkedList<String>> array = new ArrayList<LinkedList<String>>(100);

        Element<String> wordElement = list.getFirst();

        while (wordElement != null) {
            String word = wordElement.getValue();
            char letter = word.charAt(i);
            int numOfChar = (int) letter;

            setToArray(array, numOfChar, word);
            wordElement = wordElement.getNext();
        }

        return array.convertToList();
    }

    private void setToArray(ArrayList<LinkedList<String>> array, int numOfChar, String word) {
        if (array.get(numOfChar) == null) {
            LinkedList<String> elements = new LinkedList<String>();
            elements.add(word);
            array.set(numOfChar, elements);
        } else {
            LinkedList<String> elements = (LinkedList<String>) array.get(numOfChar);
            elements.add(word);
        }
    }
}
