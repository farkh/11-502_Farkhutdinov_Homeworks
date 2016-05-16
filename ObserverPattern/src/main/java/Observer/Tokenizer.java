package Observer;

/**
 * Created by farkh on 16/05/16.
 */
public class Tokenizer {
    public void process(String text) {
        TokkenizeObserver tokkenizeObserver = new TokkenizeObserver();
        String words = "";
        String digits = "";
        String signs = "";

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i)) && i > 0 && Character.isSpaceChar(text.charAt(i - 1))) {
                digits = digits + " " + text.charAt(i);
            } else if (Character.isDigit(text.charAt(i))) {
                digits += text.charAt(i);
            } else if (Character.isLetter(text.charAt(i)) && i > 0 && !Character.isLetter(text.charAt(i - 1))) {
                words = words + " " + text.charAt(i);
            } else if (Character.isLetter(text.charAt(i))) {
                words += text.charAt(i);
            } else if (!Character.isSpaceChar(text.charAt(i)) && i > 0 && (Character.isLetter(text.charAt(i - 1)) || Character.isDigit(text.charAt(i - 1)))) {
                signs = signs + " " + text.charAt(i);
            } else if (!Character.isSpaceChar(text.charAt(i))) {
                signs += text.charAt(i);
            }
        }

        tokkenizeObserver.handleDigits(digits);
        tokkenizeObserver.handleLetters(words);
        tokkenizeObserver.handleSigns(signs);


    }
}
