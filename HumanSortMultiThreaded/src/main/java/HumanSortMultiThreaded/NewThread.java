package HumanSortMultiThreaded;

import LinkedList.LinkedList;

import java.io.IOException;

/**
 * Created by farkh on 22/05/16.
 */
public class NewThread implements Runnable {
    private String name;
    Thread th;
    private String inputPath;
    private String outputPath;

    NewThread(String threadsName, String inputPath, String outputPath) {
        name = threadsName;
        th = new Thread(this, name);
        System.out.println("New thread: " + name);
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        th.start();
    }

    public void run() {
        LinkedList<Human> list = null;
        HumanReaderWriter reader = new HumanReaderWriter();

        try {
            list = reader.read(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HumanSorter sorter = new HumanSorter();
        LinkedList<Human> result = sorter.sort(list);


        reader.write(result, outputPath);
    }
}
