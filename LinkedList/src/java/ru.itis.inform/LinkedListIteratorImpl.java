public class LinkedListIteratorImpl<T> implements Iterator<T> {
  Element<T> current;

  public LinkedListIteratorImpl(Element<T> first) {
    this.current = first;
  }

  public boolean hasNext() {
    if (current.getNext() != null) {
      return true;
    } else { return false; }
  }

  public boolean hasPrevious() {
    if (current.getPrevious() != null) {
      return true;
    } else { return false; }
  }

  public T next() {
    if (current.getNext() != null) {
      return current.getNext().getValue();
    } else { return null; }
  }

  public T previous() {
    if (current.getPrevious() != null) {
      return current.getPrevious().getValue();
    } else { return null; }
  }

  //peaks next element in list
  public T peakNext() {
    if (hasNext()) {
      return current.getNext().getValue();
    } else throw new IllegalArgumentException();
  }

  //peaks previous element in list
  public T peakPrevious() {
    if (hasPrevious()) {
      return current.getPrevious().getValue();
    } else throw new IllegalArgumentException();
  } 

  public void insert(T element) {
    Element<T> newElement = new Element<T>(element);

    if (current.getPrevious() != null) {
      newElement.setPrevious(current.getPrevious());
      newElement.getPrevious().setNext(newElement);
      newElement.setNext(current);
      current.setPrevious(newElement);
    } else throw new IllegalArgumentException();
  }
}
