package LinkedList;

/**
 * Created by farkh on 17/03/16.
 */
public class LinkedListIteratorImpl<T> implements Iterator<T> {
    private Node<T> current;

    public LinkedListIteratorImpl(Node<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return current != null;
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

    public T getCurrent() {
        return current.getValue();
    }

    public T peakNext() {
        if (hasNext()) {
            return current.getValue();
        } else throw new NullPointerException();
    }

    public T peakPrevious() {
        if (hasPrevious()) {
            return current.getValue();
        } else throw new NullPointerException();
    }

    public void insert(T element) {
        Node<T> newElement = new Node<T>(element);

        if (hasPrevious()) {
            newElement.setPrevious(current.getPrevious());
            newElement.getPrevious().setNext(newElement);
            newElement.setNext(current);
            current.setPrevious(newElement);
        } else throw new NullPointerException();
    }
}
