package Jarvis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by farkh on 21/03/16.
 */
public class JarvisAlgTest {
    Point[] array = new Point[7];
    JarvisAlg alg = new JarvisAlg();

    @Before
    public void setUp() throws Exception {
        array[0] = new Point(0, 0);
        array[1] = new Point(2, 1);
        array[2] = new Point(4, 2);
        array[3] = new Point(2, 2);
        array[4] = new Point(1, 3);
        array[5] = new Point(1, 4);
        array[6] = new Point(3, 4);
    }

    /*
    @Test
    public void testStartSearching() {
        Point[] result = alg.startSearching(array);
        Point[] required = new Point[7];
        required[0] = new Point(0, 0);

        assertTrue(alg.checkEquals(required, result));
    }
    */
}