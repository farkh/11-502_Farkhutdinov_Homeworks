import LinkedList.*;

import java.io.IOException;

/**
 * Created by farkh on 06/04/16.
 */
public class Main {
    public static void main(String[] args) {
        StringReaderWriter reader = new StringReaderWriter();
        String path = "/Users/farkh/Documents/Programming/Projects/LexSort2/src/main/input.txt";

        LinkedList<Human> list = null;
        try {
            list = reader.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sorter sorter = new Sorter();
        LinkedList<Human> sorted = sorter.sortNames(list);

        reader.write(sorted, path);
    }
}
