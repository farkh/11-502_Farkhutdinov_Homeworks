package LinkedList;

/**
 * Created by farkh on 15/03/16.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(8);
        list.add(12);
        list.add(14);

        LinkedList<Integer> second = new LinkedList<Integer>();
        second.add(1);
        second.add(2);
        second.add(10);
        second.add(11);
        second.add(12);
        second.add(13);
        second.add(15);
        second.add(16);

        LinkedList<Integer> merged = LinkedList.merge(list, second);
        merged.showList();
    }
}
