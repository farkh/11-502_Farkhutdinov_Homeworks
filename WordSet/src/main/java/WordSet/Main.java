package WordSet;

import java.io.IOException;

/**
 * Created by farkh on 02/04/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String[] words = { "aaa", "bac", "cbr" };

        WordSet wordSet = new WordSet(words);
        //wordSet.insert("baab");
        //wordSet.remove("abs");

        /*

        //A list of words without palindroms
        WordSet palindromsRemoved = new WordSet(words);
        palindromsRemoved.removePalindrom();

        palindromsRemoved.out("output.txt");

        //A list of words starting with a vowel letter
        WordSet vowels = wordSet.vowelDivide()[0];
        vowels.out("output.txt");

        //A list of words starting with a consonant letter
        WordSet consonants = wordSet.vowelDivide()[0];
        consonants.out("output.txt");



        WordSet newWordSetByWordLength = wordSet.newWordSetByWordLength(3);
        newWordSetByWordLength.out("output.txt");
        */

        wordSet.out("output.txt");

        String[] anotherWords = { "abc", "bac", "cbe" };
        WordSet anotherWordSet = new WordSet(anotherWords);

        WordSet mergedWordSet = new WordSet(wordSet, anotherWordSet);

        mergedWordSet.out("output.txt");
    }
}
