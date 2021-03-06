package Farey;
import LinkedList.*;

/**
 * Created by farkh on 20/02/16.
 */
public class Rational {
    private int a;
    private int b;

    public Rational(int a, int b) {
        this.a = a;
        if (b != 0) {
            this.b = b;
        } else throw new IllegalArgumentException();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void print() {
        System.out.print(a + "/" + b);
    }
}
