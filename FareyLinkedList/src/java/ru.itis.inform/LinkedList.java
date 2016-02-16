public class LinkedList {
  private Element first;
  private int length;

  public LinkedList() {
    first = null;
    length = 0;
  }

  public void add(Rational obj) {
    Element element = new Element(obj);

    if (first == null) { first = element; }
    else {
      element.setNext(this.first);
      this.first = element;
    }
    length++;
  }

  public Element getFirst() {
    return this.first;
  }
  
  /*
  public void remove(int element) {
    Element currElement = this.first;

    for (int i = 0; i < length - 1; i++) {
      if (i == 0 & currElement.getValue() == element) {
        first = currElement.getNext();
        break;
      }

      if (currElement.getNext().getValue() == element) {
        if (i == 0) {
          first = currElement;
          currElement.setNext(null);
          break;
        } else if (i == length - 2) {
          currElement.setNext(null);
          break;
        } else {
          currElement.setNext(currElement.getNext().getNext());
          break;
        }
      }
      
      currElement = currElement.getNext();
    }
    length--;
  }
  */

  public void show() {
    Element element = first;

    while (element.getNext() != null) {
      element.getValue().print();
      System.out.print(" <-- ");
      element = element.getNext();
    }
    element.getValue().print();
  }
}
