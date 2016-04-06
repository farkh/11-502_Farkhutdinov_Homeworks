import ArrayList.*;
import LinkedList.*;

/**
 * Created by farkh on 06/04/16.
 */
public class Sorter {
    /*
    public LinkedList<Human> sort(LinkedList<Human> list) {
        LinkedList<Human> sorted = sortNames(list);


        for (int i = 0; i < )


    }
    */

    private int getMaxLength(LinkedList<Human> list) {
        int maxLength = 0;

        Node<Human> node = list.getFirst();

        while (node != null) {
            String name = node.getValue().getName();

            if (name.length() > maxLength) {
                maxLength = name.length();
            }
            node = node.getNext();
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public LinkedList<Human> sortNames(LinkedList<Human> list) {
        int maxLength = getMaxLength(list);
        //int maxLength = 5;

        for (int i = maxLength; i >= 0; i--) {
            list = sortByIndex(list, i);
        }

        return list;
    }

    private LinkedList<Human> sortByIndex(LinkedList<Human> list, int index) {
        ArrayList<LinkedList<Human>> array = new ArrayList<LinkedList<Human>>(123);

        Node<Human> node = list.getFirst();

        while (node != null) {
            Human human = node.getValue();

            char letter;

            try {
                letter = human.toString().charAt(index);
            } catch (StringIndexOutOfBoundsException e) {
                letter = ' ';
            }

            int number = (int) letter;

            setToArray(array, number, human);

            node = node.getNext();
        }

        return array.convertToList();
    }

    private void setToArray(ArrayList<LinkedList<Human>> array, int number, Human human) {
        if (array.get(number) == null) {
            LinkedList<Human> element = new LinkedList<Human>();
            element.add(human);
            array.set(number, element);
        } else {
            LinkedList<Human> element = (LinkedList<Human>) array.get(number);
            element.add(human);
        }
    }

}
