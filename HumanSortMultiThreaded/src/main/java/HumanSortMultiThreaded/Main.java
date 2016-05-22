package HumanSortMultiThreaded;

/**
 * Created by farkh on 22/05/16.
 */
public class Main {
    public static void main(String[] args) {
        String inputOne = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/input1.txt";
        String outputOne = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/output1.txt";
        NewThread thread1 = new NewThread("First", inputOne, outputOne);

        String inputTwo = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/input2.txt";
        String outputTwo = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/output2.txt";
        NewThread thread2 = new NewThread("Second", inputTwo, outputTwo);

        String inputThree = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/input3.txt";
        String outputThree = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/output3.txt";
        NewThread thread3 = new NewThread("Third", inputThree, outputThree);

        String inputFour = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/input4.txt";
        String outputFour = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/output4.txt";
        NewThread thread4 = new NewThread("Fourth", inputFour, outputFour);

        String inputFive = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/input5.txt";
        String outputFive = "/Users/farkh/Documents/Programming/Projects/HumanSortMultiThreaded/src/main/output5.txt";
        NewThread thread5 = new NewThread("Fifth", inputFive, outputFive);

        System.out.println("First thread started: " + thread1.th.isAlive());
        System.out.println("Second thread started: " + thread2.th.isAlive());
        System.out.println("Third thread started: " + thread3.th.isAlive());
        System.out.println("Fourth thread started: " + thread4.th.isAlive());
        System.out.println("Fifth thread started: " + thread5.th.isAlive());

        try {
            System.out.println("Waiting for completion of threads.");
            thread1.th.join();
            thread2.th.join();
            thread3.th.join();
            thread4.th.join();
            thread5.th.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread stopped.");
        }
    }
}
