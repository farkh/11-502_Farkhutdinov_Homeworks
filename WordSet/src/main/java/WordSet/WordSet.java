package WordSet;
import LinkedList.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

/**
 * Created by farkh on 02/04/16.
 */

public class WordSet<T extends Comparable<T>> {
    LinkedList<String> list = new LinkedList<String>();

    WordSet() {
        LinkedList<String> list = new LinkedList<String>();
    }

    WordSet(String[] array) {
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
    }

    WordSet(LinkedList<String> list) {
        this.list = list;
    }

    WordSet(WordSet w1, WordSet w2) {
        initWordSet(merge(w1, w2));
    }

    private static <T extends Comparable<T>> LinkedList merge(WordSet w1, WordSet w2) {
        LinkedList<String> merged = new LinkedList<String>();
        LinkedList<String> LfirstList = w1.get();
        LinkedList<String> LsecondList = w2.get();
        Node<String> firstWordSet = LfirstList.getFirst();
        Node<String> secondWordSet = LsecondList.getFirst();

        while (firstWordSet != null && secondWordSet != null) {
            while (firstWordSet.getValue().compareTo(secondWordSet.getValue()) > 0 && firstWordSet.getValue().length() >= secondWordSet.getValue().length() && secondWordSet.getNext() != null) {
                merged.add(secondWordSet.getValue());
                secondWordSet = secondWordSet.getNext();
            }
            if (firstWordSet.getValue().compareTo(secondWordSet.getValue()) > 0 && firstWordSet.getValue().length() >= secondWordSet.getValue().length() && secondWordSet.getNext() == null) {
                merged.add(secondWordSet.getValue());
                secondWordSet = secondWordSet.getNext();
                break;
            }

            while (firstWordSet.getValue().compareTo(secondWordSet.getValue()) <= 0 && firstWordSet.getValue().length() <= secondWordSet.getValue().length() && firstWordSet.getNext() != null) {
                merged.add(firstWordSet.getValue());
                firstWordSet = firstWordSet.getNext();
            }
            if (firstWordSet.getValue().compareTo(secondWordSet.getValue()) <= 0 && firstWordSet.getValue().length() <= secondWordSet.getValue().length() && firstWordSet.getNext() == null) {
                merged.add(firstWordSet.getValue());
                firstWordSet = firstWordSet.getNext();
                break;
            }
        }

        Node<String> remaining = null;

        if (firstWordSet != null) {
            remaining = firstWordSet;
        } else if (secondWordSet != null) {
            remaining = secondWordSet;
        }

        while (remaining != null) {
            merged.add(remaining.getValue());
            remaining = remaining.getNext();
        }

        //!!!!!!!!!
        merged.showList();

        return merged;

    }

    private void initWordSet(LinkedList<String> list) {
        this.list = list;
    }

    private int compareWords(String wordOne, String wordTwo) {
        if (wordOne.length() > wordTwo.length()) {
            return 1;
        } else if (wordOne.length() < wordTwo.length()) {
            return -1;
        }

        if (wordOne == wordTwo) {
            return 0;
        }

        for (int i = 0; i < wordOne.length(); i++) {
            if (wordOne.charAt(i) < wordTwo.charAt(i)) {
                return -1;
            }
        }

        return 1;
    }

    //Adds to the list a new word without breaking the sequence
    public void insert(String word) {
        Node<String> current = list.getFirst();

        while (current != null) {
            String another = (String) current.getValue();

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == another.charAt(i)) {}
                else if (word.charAt(i) < another.charAt(i)) {
                    Node<String> node = new Node<String>(word);
                    current.getPrevious().setNext(node);
                    node.setPrevious(current.getPrevious());
                    node.setNext(current);
                    current.setPrevious(node);
                    return;
                } else { break; }
            }
            current = current.getNext();
        }
        list.getLast().setNext(new Node<String>(word));
        return;
    }

    //Removes from the list the word
    public void remove(String word) {
        Node<String> current = list.getFirst();
        int currentLenght = 0;

        while (current != null) {
            String another = (String) current.getValue();

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == another.charAt(i)) {
                    currentLenght++;

                    if (currentLenght == word.length() && current.getNext() != null && current.getPrevious() != null) {
                        current.getNext().setPrevious(current.getPrevious());
                        current.getPrevious().setNext(current.getNext());
                        return;
                    } else if (currentLenght == word.length() && current.getNext() != null) {
                        current.getNext().setPrevious(null);
                        list.setFirst(current.getNext());
                    } else if (currentLenght == word.length() && current.getPrevious() != null) {
                        current.getPrevious().setNext(null);
                    }
                } else {
                    currentLenght = 0;
                    break;
                }
            }
            current = current.getNext();
        }
        return;
    }

    public LinkedList<String> get() {
        return this.list;
    }

    //Returns a new list consisting of words of a given length
    public WordSet<String> newWordSetByWordLength(int length) {
        Node<String> currentNode = list.getFirst();
        LinkedList<String> newSet = new LinkedList<String>();

        while (currentNode != null) {
            String currentWord = (String) currentNode.getValue();

            if (currentWord.length() == length) {
                newSet.add(currentWord);
            }

            currentNode = currentNode.getNext();
        }

        WordSet<String> newWordSet = new WordSet<String>(newSet);

        return newWordSet;
    }

    public WordSet[] vowelDivide() {
        Node<String> current = list.getFirst();
        LinkedList<String> vowels = new LinkedList<String>();
        LinkedList<String> consonants = new LinkedList<String>();

        while (current != null) {
            char letter = (char) current.getValue().charAt(0);

            if (isVowel(letter)) {
                vowels.add(current.getValue());
            }

            if (isConsonant(letter)) {
                consonants.add(current.getValue());
            }

            current = current.getNext();
        }

        WordSet<String>[] vowelDivided = new WordSet[2];
        vowelDivided[0] = new WordSet<String>(vowels);
        vowelDivided[1] = new WordSet<String>(consonants);

        return vowelDivided;
    }

    private boolean isVowel(char letter) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };

        for (int i = 0; i < vowels.length; i++) {
            if (letter == vowels[i]) {
                return true;
            }
        }

        return false;
    }

    private boolean isConsonant(char letter) {
        char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z' };

        for (int i = 0; i < consonants.length; i++) {
            if (letter == consonants[i]) {
                return true;
            }
        }

        return false;
    }

    //Removes palindroms
    public void removePalindrom() {
        Node<String> current = list.getFirst();

        while (current != null) {
            if (isPalindrom(current.getValue())) {
                remove(current.getValue());
            }
            current = current.getNext();
        }
    }

    //Checks whether the word is a palindrome
    public boolean isPalindrom(String word) {
        boolean palindrom = false;
        int middle = word.length() / 2;

        for (int i = 0; i < middle; i++) {
            for (int j = word.length() - i - 1; j >= middle; j--) {
                if (word.charAt(i) == word.charAt(j)) {
                    palindrom = true;
                    break;
                } else {
                    return false;
                }
            }
        }

        return palindrom;
    }

    public void out(String filename) {
        Node<String> node = list.getFirst();

        String word = node.toString() + "\n";

        Path file = Paths.get("/Users/farkh/Documents/Programming/Projects/WordSet/src/main/output.txt");

        try {
            Files.write(file, word.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        node = node.getNext();

        while (node != null) {
            word = node.toString() + "\n";
            try {
                Files.write(file, word.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            node = node.getNext();
        }
    }
}
