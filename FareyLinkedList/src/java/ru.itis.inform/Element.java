public class Element {
  private Rational value;
  private Element next;

  public Element(Rational value) {
    this.value = value;
  }

  public void setNext(Element next) {
    this.next = next;
  }

  public Rational getValue() {
    return this.value;
  }

  public Element getNext() {
    return this.next;
  }
}
