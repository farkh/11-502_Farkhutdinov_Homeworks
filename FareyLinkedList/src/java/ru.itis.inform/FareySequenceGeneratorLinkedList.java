public class FareySequenceGeneratorLinkedList {
  private final int DEFAULT_LIST_LENGTH = 50;

  private LinkedList list;
  private int currentNumber = 0;
  private int finalNumber;
  
  public FareySequenceGeneratorLinkedList(int listLength) {
    initFareySequenceGeneratorLinkedList(listLength);
  }

  public FareySequenceGeneratorLinkedList() {
    initFareySequenceGeneratorLinkedList(DEFAULT_LIST_LENGTH);
  }

  private void initFareySequenceGeneratorLinkedList(int listLength) {
    this.finalNumber = listLength;
    this.list = new LinkedList();
    this.list.add(new Rational(0, 1));
    this.list.add(new Rational(1, 1));
    this.currentNumber = 2;
  }

  /*
  public int getFinalNumber() {
    return finalNumber;
  }

  public int getCurrentNumber() {
    return currentNumber;
  }
  */

  public void generate() {
    for (int iter = 2; iter <= finalNumber; iter++) {
      Element element = list.getFirst(); 
      do {
        if (element.getValue().getB() + element.getNext().getValue().getB() == iter) {
          int a = element.getValue().getA() + element.getNext().getValue().getA();
          Element newElement = new Element(new Rational(a, iter));
          newElement.setNext(element.getNext());
          element.setNext(newElement);
        }
        element = element.getNext();
      } while (element.getNext() != null);
    }    
  } 

  public void show() {
    list.show();
  }
}
