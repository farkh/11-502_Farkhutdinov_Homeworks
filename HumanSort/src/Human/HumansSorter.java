package Human;
import LinkedList.*;
import ArrayList.*;

/**
 * Created by farkh on 28/02/16.
 */
public class HumansSorter {
    public LinkedList<Human> sort(LinkedList<Human> list) {
        ArrayList<LinkedList<Human>> arrayList = new ArrayList<LinkedList<Human>>(50);

        Element<Human> element = list.getFirst();

        while (element != null) {
            Human human = element.getValue();
            int age = human.getAge();

            if (arrayList.get(age) == null) {
                LinkedList<Human> elem = new LinkedList<Human>();
                elem.add(human);
                arrayList.set(age, elem);
            } else {
                LinkedList<Human> elem = (LinkedList<Human>) arrayList.get(age);
                elem.add(human);
            }
            element = element.getNext();
        }
        LinkedList<Human> sorted = arrayList.convertToList();

        return sorted;
    }
}
