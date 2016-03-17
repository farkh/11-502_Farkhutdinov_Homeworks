package LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by farkh on 15/03/16.
 */
public class LinkedListTest {
    LinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<Integer>();
        list.add(3);
        list.add(8);
        list.add(12);
        list.add(17);
        list.add(18);
        list.add(19);
        list.add(20);
    }

    @Test
    public void testRemove() {
        LinkedList<Integer> required = new LinkedList<Integer>();
        required.add(8);
        required.add(12);
        required.add(17);
        required.add(18);

        list.remove(3);
        list.remove(19);
        list.remove(20);

        assertTrue(list.checkEquals(required));
    }

    @Test
    public void testMerge() {
        LinkedList<Integer> secondList = new LinkedList<Integer>();

        secondList.add(1);
        secondList.add(2);
        secondList.add(10);
        secondList.add(21);

        LinkedList<Integer> merged = LinkedList.merge(this.list, secondList);

        LinkedList<Integer> required = new LinkedList<Integer>();

        required.add(1);
        required.add(2);
        required.add(3);
        required.add(8);
        required.add(10);
        required.add(12);
        required.add(17);
        required.add(18);
        required.add(19);
        required.add(20);
        required.add(21);

        assertTrue(merged.checkEquals(required));
    }

    @Test
    public void testMergeSort() {
        LinkedList<Integer> sort = new LinkedList<Integer>();
        sort.add(5);
        sort.add(3);
        sort.add(7);
        sort.add(2);
        sort.add(1);

        LinkedList<Integer> sorted = LinkedList.mergeSort(sort);

        LinkedList<Integer> required = new LinkedList<Integer>();
        required.add(1);
        required.add(2);
        required.add(3);
        required.add(5);
        required.add(7);

        assertTrue(sorted.checkEquals(required));
    }
}