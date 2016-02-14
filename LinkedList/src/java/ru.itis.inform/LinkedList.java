public class LinkedList {
  private Element first;
  private int length;

  public LinkedList() {
    first = null;
    length = 0;
  }

  public void add(int value) {
    Element element = new Element(value);

    if (first == null) { first = element; }
    else {
      element.setNext(this.first);
      this.first = element;
    }
    length++;
  }
  
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

  public void show() {
    Element element = first;

    while (element.getNext() != null) {
      System.out.print(element.getValue() + "-->");
      element = element.getNext();
    }
    System.out.print(element.getValue());
  }
}
