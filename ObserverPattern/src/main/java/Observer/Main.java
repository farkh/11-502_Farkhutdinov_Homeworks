package Observer;

/**
 * Created by farkh on 16/05/16.
 */
public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();

        String string = "Hello, 1234 and 15!";

        tokenizer.process(string);
    }
}
