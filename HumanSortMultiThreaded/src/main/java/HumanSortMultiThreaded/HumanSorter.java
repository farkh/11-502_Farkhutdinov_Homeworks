package HumanSortMultiThreaded;

import LinkedList.*;

import ArrayList.*;

public class HumanSorter {
    public LinkedList<Human> sort(LinkedList<Human> list) {
        ArrayList<LinkedList<Human>> arrayList = new ArrayList<LinkedList<Human>>(100);

        Node<Human> node = list.getFirst();

        while (node != null) {
            Human human = node.getValue();
            int age = human.getAge();

            if (arrayList.get(age) == null) {
                LinkedList<Human> element = new LinkedList<Human>();
                element.add(human);
                arrayList.set(age, element);
            } else {
                LinkedList<Human> element = (LinkedList<Human>) arrayList.get(age);
                element.add(human);
            }

            node = node.getNext();
        }

        LinkedList<Human> result = arrayList.convertToList();

        return result;
    }

}
