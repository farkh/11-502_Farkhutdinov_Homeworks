package Observer;

/**
 * Created by farkh on 16/05/16.
 */
public class TokkenizeObserver {
    public void handleDigits(String digits) {
        System.out.println("Digits: " + digits);
    }

    public void handleLetters(String letters) {
        System.out.println("Letters: " + letters);
    }

    public void handleSigns(String signs) {
        System.out.println("Signs: " + signs);
    }
}
