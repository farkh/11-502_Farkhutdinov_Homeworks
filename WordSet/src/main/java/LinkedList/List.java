package LinkedList;

/**
 * Created by farkh on 15/03/16.
 */
public interface List<T extends Comparable<T>> {
    void add(T element);
    void remove(T element);
    Node<T> getFirst();
    Node<T> getLast();
    int getLength();
    void showList();
    void append(LinkedList list);
}
