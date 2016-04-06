import LinkedList.*;
import java.io.*;
import java.nio.file.*;

/**
 * Created by farkh on 06/04/16.
 */
public class StringReaderWriter<T> {

    public LinkedList<Human> read(String path) throws IOException {
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        LinkedList<Human> list = new LinkedList<Human>();

        String line = reader.readLine();

        while (line != null) {
            System.out.println(line);
            list.add(makeHuman(line));
            line = reader.readLine();
        }
        return list;
    }

    private Human makeHuman(String nameAge) {
        String[] params = nameAge.split(" ");
        return new Human(params[0], Integer.parseInt(params[1].replace("\\s", "")));
    }

    public void write(LinkedList<Human> list, String path) {
        writeHuman(list, "/Users/farkh/Documents/Programming/Projects/LexSort2/src/main/output.txt");
    }

    private void writeHuman(LinkedList<Human> list, String path) {
        Node<Human> node = list.getFirst();

        String value = node.toString() + "\n";

        Path file = Paths.get(path);

        try {
            Files.write(file, value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        node = node.getNext();

        while (node != null) {
            value = node.toString() + "\n";
            try {
                Files.write(file, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            node = node.getNext();
        }
    }
}
