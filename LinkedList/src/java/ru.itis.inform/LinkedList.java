public class LinkedList<T> implements List<T> {
  private Element<T> first;
  private int count;
  
  public LinkedList() {
    this.first = null;
    this.count = 0;
  }

  public void add(T element) {
    Element<T> newElement = new Element<T>(element);
    newElement.setPrevious(null);
    if (first == null) {
      this.first = newElement;
    } else {
      newElement.setNext(this.first);
      first.setPrevious(newElement);
      first = newElement;
    }
    this.count++;
  } 

  public void remove(T element) {
    Element<T> currElement = this.first;

    for (int i = 0; i < count - 1; i++) {
      if (i == 0 && currElement.getValue() == element) {
        first = currElement.getNext();
        break;
      }

      if (currElement.getNext().getValue() == element) {
        if (i == 0) {
          first = currElement;
          currElement.setNext(null);
          break;
        } else if (i == count - 2) {
          currElement.setNext(null);
          break;
        } else {
          currElement.setNext(currElement.getNext().getNext());
          break;
        }
      }
    }
  }

  public Iterator<T> iterator() {
    return new LinkedListIteratorImpl<T>(this.first);
  }
}
