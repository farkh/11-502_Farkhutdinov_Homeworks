public class LinkedListIteratorImpl<T> implements Iterator<T> {
  Element<T> current;

  public LinkedListIteratorImpl(Element<T> first) {
    this.current = first;
  }

  public boolean hasNext() {
    return current != null;
  }

  public T next() {
    T value = current.getValue();
    current = current.getNext();
    return value;
  }

  public T previous() {
    if (current.getPrevious() != null) {
      return current.getPrevious().getValue();
    } else { return null; }
  }

  public void insert(T element) {

  }
}
