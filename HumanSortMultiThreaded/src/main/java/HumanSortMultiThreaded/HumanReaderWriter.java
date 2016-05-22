package HumanSortMultiThreaded;

import java.io.*;
import java.nio.file.*;
import LinkedList.*;

public class HumanReaderWriter {
    public LinkedList<Human> read(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        LinkedList<Human> list = new LinkedList<Human>();

        String line = reader.readLine();
        list.add(createHumanFromString(line));

        while (line != null) {
            line = reader.readLine();
            if (line != null) {
                Human newHuman = createHumanFromString(line);
                list.add(newHuman);
            }
        }
        return list;
    }

    public void write(LinkedList<Human> list, String path) {
        writeHumans(list, path);
    }

    public void writeHumans(LinkedList<Human> list, String path) {
        Node<Human> node = list.getLast();
        String value = node.toString() + "\n";

        Path file = Paths.get(path);

        try {
            Files.write(file, value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        node = node.getPrevious();
        while (node != null) {
            value = node.toString() + "\n";
            try {
                Files.write(file, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            node = node.getPrevious();
        }
    }

    public Human createHumanFromString(String params) {
        String[] attributes = params.split(" ");
        return new Human(attributes[0], Integer.parseInt(attributes[1]));
    }
}
