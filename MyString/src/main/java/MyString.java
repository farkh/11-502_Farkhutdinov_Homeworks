/**
 * Created by farkh on 26/04/16.
 */
public class MyString {
    private char[] characters;
    private int length;

    public MyString (String string) {
        length = string.length();
        characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = string.charAt(i);
        }
    }

    public int length() {
        return length;
    }

    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException();
        }

        return characters[index];
    }

    public int indexOf(int ch, int from) {
        if (from < 0) {
            from = 0;
        } else if (from >= length) {
            return -1;
        }

        for (int i = from; i < length; i++) {
            if (characters[i] == ch) {
                return i;
            }
        }

        return -1;
    }

    public int indexOf(int ch) {
        return indexOf(ch, 0);
    }

    public int indexOf(MyString string, int from) {
        if (from < 0) {
            from = 0;
        } else if (from >= length) {
            return -1;
        }

        for (int i = from; i < length; i++) {
            if (characters[i] == string.charAt(0)) {
                if (string.length == 1) {
                    return i;
                }

                int offset = 1;

                while (offset < string.length() && (i + offset) < length && string.charAt(offset) == characters[i + offset]) {
                    if (offset == string.length - 1) {
                        return i;
                    }
                    offset++;
                }
            }
        }
        return -1;
    }

    public int indexOf(MyString string) {
        return indexOf(string, 0);
    }

    public boolean equals(Object ob) {
        MyString another;

        if (!(ob instanceof MyString)) {
            return false;
        } else {
            another = (MyString) ob;
        }

        if (this.length != another.length()) {
            return false;
        }

        int i = 0;
        while (i < this.length) {
            if (this.characters[i] != another.charAt(i)) {
                return false;
            }
            i++;
        }

        return true;
    }

    public int compareTo(MyString another) {
        if (this.length != another.length()) {
            return this.length - another.length;
        }

        for (int i = 0; i < length; i++) {
            if (this.characters[i] != another.charAt(i)) {
                return this.characters[i] - another.charAt(i);
            }
        }

        return 0;
    }

    public String toString() {
        return new String(characters);
    }

    /*
    public int hashCode() {

    }
    */

}
