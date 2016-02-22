package LinkedList;

import Iterator.*;
import Farey.*;
/**
 * Created by farkh on 20/02/16.
 */

public class LinkedList<T> implements List<T> {
    private Element<T> first;
    private int length;

    public LinkedList() {
        this.first = null;
        length = 0;
    }

    public Element<T> getFirst() {
        return this.first;
    }

    @Override
    public void add(T element) {
        Element<T> newElement = new Element<T>(element);
        newElement.setPrevious(null);
        if (first == null) {
            this.first = newElement;
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

    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }
}

