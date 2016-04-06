package LinkedList;

/**
 * Created by farkh on 06/04/16.
 */

public interface List<T> {
    void add(T element);
    void remove(T element);
    Node<T> getFirst();
    Node<T> getLast();
    int getLength();
    void showList();
    void append(LinkedList list);
}