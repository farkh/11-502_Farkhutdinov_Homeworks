package Human;
import LinkedList.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by farkh on 24/02/16.
 */
public class HumansReaderWriter {


    public LinkedList<Human> readHumans(String fileName) {
        //read file input.txt
        LinkedList<Human> list = new LinkedList<Human>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            list.add(makeHuman(line));

            while (line != null) {
                list.add(makeHuman(line));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Human makeHuman(String line) {
        String[] div = line.split(" ", 2);
        String str = div[0];
        int age = Integer.valueOf(div[1]);
        return new Human(str, age);
    }

    public void writeHumans(LinkedList<Human> humans) {
        //write new file output.txt
        Element<Human> element = humans.getFirst();

        String value = element.toString() + "\n";

        Path file = Paths.get("/Users/farkh/Documents/Programming/11-502_Farkhutdinov_Homeworks/HumanSort/src/output.txt");

        /*
        try {
            FileWriter writer = new FileWriter("/Users/farkh/Documents/Programming/11-502_Farkhutdinov_Homeworks/HumanSort/src/output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        try {
            Files.write(file, value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        element = element.getNext();

        while (element != null) {
            value = element.toString() + "\n";

            try {
                Files.write(file, value.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            element = element.getNext();
        }
    }
    /*
    public void writeHumans(LinkedList<Human> humans) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("/Users/farkh/Documents/Programming/11-502_Farkhutdinov_Homeworks/HumanSort/src/output.txt"));

        Element<Human> element = humans.getFirst();
        do {
            writer.write(element.toString());
            writer.write("out");
            element = element.getNext();
        } while (element != null);
    }
    */
}
