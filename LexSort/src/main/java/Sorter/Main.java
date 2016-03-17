package Sorter;
import lists.*;

import java.io.IOException;

/**
 * Created by farkh on 29/02/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StringReaderWriter reader = new StringReaderWriter();
        String path = "/Users/farkh/Documents/Programming/11-502_Farkhutdinov_Homeworks/LexSort/src/main/java/input.txt";

        LinkedList<String> list = reader.read(path);
        LexSorter sorter = new LexSorter();
        LinkedList<String> res = sorter.sort(list);
        reader.write(res);
    }
}
