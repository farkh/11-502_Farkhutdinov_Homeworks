package Human;

import LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
	    HumansReaderWriter reader = new HumansReaderWriter();
        String path = "../input.txt";

        LinkedList<Human> list = reader.readHumans(path);

        HumansSorter sorter = new HumansSorter();
        LinkedList<Human> sorted = sorter.sort(list);

        reader.writeHumans(sorted);
    }
}
