package Iterator;

import LinkedList.*;

public class LinkedListIteratorImpl<T> implements Iterator<T> {
    private Element<T> current;

    public LinkedListIteratorImpl(Element<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return current.getNext() != null;
    }

    public boolean hasPrevious() {
        return current.getPrevious() != null;
    }

    public T next() {
        if (hasNext()) {
            T value = this.current.getValue();
            this.current = current.getNext();
            return value;
        } else throw new NullPointerException();
    }

    public T previous() {
        if (hasPrevious()) {
            T value = this.current.getValue();
            this.current = current.getPrevious();
            return value;
        } else throw new NullPointerException();
    }

    public T peakNext() {
        if (hasNext()) {
            return current.getNext().getValue();
        } else throw new NullPointerException();
    }

    public T peakPrevious() {
        if (hasPrevious()) {
            return current.getPrevious().getValue();
        } else throw new NullPointerException();
    }

    public void insert(T element) {
        Element<T> newElement = new Element<T>(element);

        if (hasPrevious()) {
            newElement.setPrevious(current.getPrevious());
            newElement.getPrevious().setNext(newElement);
            newElement.setNext(current);
            current.setPrevious(newElement);
        } else throw new NullPointerException();
    }
}
