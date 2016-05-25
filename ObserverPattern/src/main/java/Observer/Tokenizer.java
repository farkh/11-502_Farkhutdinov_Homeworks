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
            if ((Character.isDigit(text.charAt(i)) && i < text.length() - 1 && !Character.isDigit(text.charAt(i + 1))) || (Character.isDigit(text.charAt(i)) && i == text.length() - 1)) {
                digits += text.charAt(i);
                tokkenizeObserver.handleDigits(digits);
                digits = "";
            } else if (Character.isDigit(text.charAt(i)) ) {
                digits += text.charAt(i);
            } else if ((Character.isLetter(text.charAt(i)) && i < text.length() - 1 && !Character.isLetter(text.charAt(i + 1)))  || (Character.isLetter(text.charAt(i)) && i == text.length() - 1)) {
                words += text.charAt(i);
                tokkenizeObserver.handleLetters(words);
                words = "";
            } else if (Character.isLetter(text.charAt(i))) {
                words += text.charAt(i);
            } else if ((!Character.isSpaceChar(text.charAt(i)) && i < text.length() - 1 && (Character.isSpaceChar(text.charAt(i + 1)) || Character.isDigit(text.charAt(i + 1)) || Character.isLetter(text.charAt(i + 1)))) || !Character.isSpaceChar(text.charAt(i)) && i == text.length() - 1) {
                signs += text.charAt(i);
                tokkenizeObserver.handleSigns(signs);
                signs = "";
            } else if (!Character.isSpaceChar(text.charAt(i))) {
                signs += text.charAt(i);
            }
        }






    }
}
