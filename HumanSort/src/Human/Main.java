package Human;

import LinkedList.LinkedList;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
	    HumansReaderWriter reader = new HumansReaderWriter();
        String path = "/Users/farkh/Documents/Programming/11-502_Farkhutdinov_Homeworks/HumanSort/src/input.txt";

        LinkedList<Human> list = reader.readHumans(path);

        HumansSorter sorter = new HumansSorter();
        LinkedList<Human> sorted = sorter.sort(list);

        reader.writeHumans(sorted);
        //reader.out("output.txt");
    }
}
