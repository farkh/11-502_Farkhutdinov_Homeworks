package LinkedList;

/**
 * Created by farkh on 06/04/16.
 */

public class Node<T>  {
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }
    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
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
