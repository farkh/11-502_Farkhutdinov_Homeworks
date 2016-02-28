package LinkedList;

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

    @Override
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

    @Override
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

    public void append(LinkedList list) {
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
}

