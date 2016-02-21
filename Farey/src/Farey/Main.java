package Farey;

import Iterator.*;
import LinkedList.*;
/**
 * Created by farkh on 20/02/16.
 */
public class Main {
    public static void main(String args[]) {
        FareySequenceGeneratorLinkedList fareySequence = new FareySequenceGeneratorLinkedList();
        fareySequence.generate();
        fareySequence.show();

    }
}
