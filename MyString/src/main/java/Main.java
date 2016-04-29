/**
 * Created by farkh on 29/04/16.
 */
public class Main {
    public static void main(String[] args) {
        MyString string = new MyString("key");
        System.out.println(string.toString() + " " + string.hashCode());

        string = new MyString("another");
        System.out.println(string.toString() + " " + string.hashCode());

        string = new MyString("yep, this is also a string");
        System.out.println(string.toString() + " " + string.hashCode());
    }
}
