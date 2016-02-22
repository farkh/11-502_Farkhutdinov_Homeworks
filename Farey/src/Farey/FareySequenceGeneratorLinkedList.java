package Farey;

import LinkedList.*;
import Iterator.*;

/**
 * Created by farkh on 20/02/16.
 */
public class FareySequenceGeneratorLinkedList {
    private final int DEFAULT_LENGTH = 6;

    private LinkedList<Rational> list;
    private int finalNumber;

    public FareySequenceGeneratorLinkedList(int listLength) {
        initFareySequenceGeneratorLinkedList(listLength);
    }

    public FareySequenceGeneratorLinkedList() {
        initFareySequenceGeneratorLinkedList(DEFAULT_LENGTH);
    }

    private void initFareySequenceGeneratorLinkedList(int listLength) {
        this.finalNumber = listLength;
        this.list = new LinkedList<Rational>();
        this.list.add(new Rational(0, 1));
        this.list.add(new Rational(1, 1));
        list.showList();
    }

    public void generate() {
        for (int i = 2; i <= finalNumber; i++) {
            Iterator<Rational> iter = list.iterator();
            iter.next();
            while (iter.hasNext()) {
                Rational currentValue = iter.previous();
                Rational previousValue = iter.next();
                if (currentValue.getB() + previousValue.getB() == i) {
                    int a = currentValue.getA() + previousValue.getA();
                    iter.insert(new Rational(a, i));
                    previousValue = iter.peakPrevious();
                }
                iter.next();
            }
        }
    }

    public void show() {
        Iterator<Rational> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
    }
}
