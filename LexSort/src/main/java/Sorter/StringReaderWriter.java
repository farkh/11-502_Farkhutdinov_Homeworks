package Sorter;
import lists.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by farkh on 29/02/16.
 */
public class StringReaderWriter {
    public LinkedList<String> read(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        LinkedList<String> list = new LinkedList<String>();

        String line = reader.readLine();

        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        return list;
    }

    public void write(LinkedList<String> list) {
        Element<String> element = list.getFirst();

        String value = element + "\n";

        Path file = Paths.get("/Users/farkh/Documents/Programming/Projects/LexSort/src/main/java/output.txt");

        try {
            Files.write(file, value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        element = element.getNext();

        while (element != null) {
            value = element + "\n";
            try {
                Files.write(file, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            element = element.getNext();
        }
    }

}
