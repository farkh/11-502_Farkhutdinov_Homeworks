
public class FareySequenceGenerator {
  private Rational array[];
  //current number of elements in sequence
  private int currentNumber = 0;
  //number of elements in sequence
  private int number;

  //Default number of elements
  private final int DEFAULT_NUMBER = 8;
  //Default array length
  private final int DEFAULT_ARRAY_LENGTH = 50;

  public FareySequenceGenerator(int number, int arrayLength) {
    initFareySequenceGenerator(number, arrayLength);
  }

  public FareySequenceGenerator() {
    initFareySequenceGenerator(DEFAULT_NUMBER, DEFAULT_ARRAY_LENGTH);
  }

  private void initFareySequenceGenerator(int number, int arrayLength) {
    this.number = number;
    this.array = new Rational[arrayLength];
    this.array[0] = new Rational(0, 1);
    this.array[1] = new Rational(1, 1);
    this.currentNumber = 2;
  }

  //get number of elements
  public int getNumber() {
    return number;
  }

  //get current number of elemetns
  public int currentNumber() {
    return currentNumber;
  }

  public Rational[] getArray() {
    return array;
  }

  public void move(int start) {
    for (int i = currentNumber; i >= start; i--) {
      array[i + 1] = array[i];
    }
  }

  //generate element
  public void generate() {
    for (int iter = 2; iter <= number; iter++) {
      int i = 0;
      while (i != currentNumber) {
        checkElements(i, iter);
        i++;
      }
    }
  }

  public void checkElements(int n, int iteration) {
    if (array[n + 1] != null) {
      if (array[n].getB() + array[n + 1].getB() == iteration) {
        currentNumber++;
        move(n + 1);
        array[n + 1] = generateElement(n);
      }
    }
  }

  //generate element
  public Rational generateElement(int number) {
    int a = array[number].getA() + array[number + 1].getA();
    int b = array[number].getB() + array[number + 1].getB();
    return new Rational(a, b);
  }
  /*
  public void show() {
    for (Rational r : array) {
      if (r != null) { 
        r.printSequence();
      }
    }
  }
  */

  public void show() {
    for (Rational r : array) {
      if (r != null) {
        System.out.print(r.getA() + "   ");
      }
    }
    System.out.println();
    for (Rational a : array) {
      if (a != null) {
        System.out.print("- , ");
      }
    }
    System.out.println();
    for (Rational t : array) {
      if (t != null) {
        System.out.print(t.getB() + "   ");
      }
    }
    System.out.println();
  }
}
