package LinkedList;

/**
 * Created by farkh on 20/02/16.
 */

public class Element<T> {
    private T value;
    private Element<T> next;
    private Element<T> previous;

    public Element(T value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public void setPrevious(Element<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public Element<T> getNext() {
        return next;
    }

    public Element<T> getPrevious() {
        return previous;
    }

    public void show() {
        System.out.println(value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
