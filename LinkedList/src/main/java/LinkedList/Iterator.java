package LinkedList;

/**
 * Created by farkh on 17/03/16.
 */
public interface Iterator<T> {
    boolean hasNext();
    boolean hasPrevious();
    T next();
    T previous();
    T peakNext();
    T peakPrevious();
    T getCurrent();
    void insert(T element);
}
