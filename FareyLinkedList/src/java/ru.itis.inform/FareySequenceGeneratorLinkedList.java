public class FareySequenceGeneratorLinkedList {
  private final int DEFAULT_LENGTH = 6;

  private LinkedList<Rational> list;
  private int finalNumber; //length
  
  public FareySequenceGeneratorLinkedList(int listLength) {
    initFareySequenceGeneratorLinkedList(listLength);
  }

  public FareySequenceGeneratorLinkedList() {
    initFareySequenceGeneratorLinkedList(DEFAULT_LENGTH);
  }

  private void initFareySequenceGeneratorLinkedList(int listLength) {
    this.finalNumber = listLength;
    this.list = new LinkedList<Rational>();
    this.list.add(new Rational(0, 1));
    this.list.add(new Rational(1, 1));
  }

  public void generate() {
    int i = 2;

    while (i <= finalNumber) {
      Iterator<Rational> iter = list.Iterator();
      iter.next();
      while (iter.hasNext()) {
        Rational currentValue = iter.previous();
        Rational previousValue = iter.next();
        if (currentValue.getB() + previousValue.getB() == i) {
          int a = currentValue.getA() + previousValue.getA();
          iter.insert(new Rational(a, i));
          previousValue = iter.peakPrevious();
        }
        iter.next();
      }
      i++;
    }
  }

  public void show() {
    Iterator<Rational> iter = list.iterator();
    while(iter.hasNext()) {
      System.out.print(iter.next() + ", ");
    }
    System.out.println();
  }
}
