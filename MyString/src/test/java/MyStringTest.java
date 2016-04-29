import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by farkh on 29/04/16.
 */

public class MyStringTest {
    MyString myString = new MyString("key");
    String string;


    @Before
    public void setUp() throws Exception {
        string = "key";
    }

    @Test
    public void testLength() {
        assertTrue(string.length() == myString.length());
    }

    @Test
    public void testCharAt() {
        char required = 'e';
        assertTrue(required == myString.charAt(1));
    }

    @Test
    public void testIndexOf() {
        int required = 2;
        assertTrue(required == myString.indexOf('y'));
    }

    @Test
    public void testHashCode() {
        int required = 19 * 37 + string.hashCode();
        assertTrue(required == myString.hashCode());
    }
}