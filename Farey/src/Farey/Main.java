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

        FareySequenceGeneratorArray fareySequenceArray = new FareySequenceGeneratorArray(3, 10);
        fareySequenceArray.generateFarey();
        fareySequenceArray.show();
    }
}
