package lists;
import Iterator.*;

/**
 * Created by farkh on 20/02/16.
 */

public class LinkedList<T> implements List<T> {
    private Element<T> first;
    private Element<T> last;
    private int length;

    public LinkedList() {
        this.first = null;
        length = 0;
        this.last = null;
    }

    public Element<T> getFirst() { return this.first; }
    public Element<T> getLast() { return this.last; }
    public int getLength() { return this.length; }

    public void add(T element) {
        Element<T> newElement = new Element<T>(element);
        newElement.setPrevious(null);
        if (first == null) {
            this.first = newElement;
            this.last = newElement;
        } else {
            newElement.setNext(this.first);
            first.setPrevious(newElement);
            first = newElement;
        }
        this.length++;
    }

    public void remove(T element) {
        Element<T> currElement = this.first;

        for (int i = 0; i < length - 1; i++) {
            if (i == 0 && currElement.getValue() == element) {
                first = currElement.getNext();
                length--;
                break;
            }
            if (currElement.getNext().getValue() == element) {
                if (i == 0) {
                    first = currElement;
                    currElement.setNext(null);
                    length--;
                    break;
                } else if (i == length - 2) {
                    currElement.setNext(null);
                    length--;
                    break;
                } else {
                    currElement.setNext(currElement.getNext().getNext());
                    length--;
                    break;
                }
            }
            currElement = currElement.getNext();
        }
    }

    public void showList() {
        Element<T> showingElement = this.first;

        while(showingElement != null) {
            showingElement.show();
            showingElement = showingElement.getNext();
        }
    }

    public void append(LinkedList<T> list) {
        this.last.setNext(list.getFirst());
        list.getFirst().setPrevious(last);
        this.last = list.getLast();
        this.length += list.getLength();
    }

    /*
    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }
    */

    public LinkedListIteratorImpl iterate() {
        return new LinkedListIteratorImpl(this.first);
    }

    public static <T extends Comparable<T>> LinkedList merge(LinkedList<T> first, LinkedList<T> second) {
        LinkedList merged = new LinkedList();
        LinkedListIteratorImpl iterator1 = first.iterate();
        LinkedListIteratorImpl iterator2 = second.iterate();
        T value1 = (T) iterator1.next();
        T value2 = (T) iterator2.next();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            while (value1.compareTo(value2) <= 0 && iterator2.hasNext()) {
                merged.add(value2);
                value2 = (T) iterator2.next();
            }
            while (value1.compareTo(value2) > 0 && iterator1.hasNext()) {
                merged.add(value1);
                value1 = (T) iterator1.next();
            }
        }
        LinkedListIteratorImpl remaining;
        if (iterator1.hasNext()) {
            while (iterator1.hasNext()) {
                merged.add(iterator1);
            }
        } else {
            while (iterator2.hasNext()) {
                merged.add(iterator2);
            }
        }
        return merged;
    }
}

