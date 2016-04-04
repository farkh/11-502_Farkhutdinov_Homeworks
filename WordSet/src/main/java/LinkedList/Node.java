package LinkedList;

/**
 * Created by farkh on 15/03/16.
 */
public class Node<T extends Comparable<T>> implements Comparable {
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

    public int compareTo(Object second) {
        if (second instanceof Node) {
            Node<T> secondNode = (Node<T>) second;
            return this.value.compareTo(secondNode.getValue());
        } else {
            return -1;
        }
    }
}
