package Farey;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by farkh on 22/02/16.
 */

public class FareySequenceGeneratorArrayTest {
    private Rational[] getExpected() {
        Rational[] expected = new Rational[10];
        expected[0] = new Rational(0, 1);
        expected[1] = new Rational(1, 4);
        expected[2] = new Rational(1, 3);
        expected[3] = new Rational(1, 2);
        expected[4] = new Rational(2, 3);
        expected[5] = new Rational(3, 4);
        expected[6] = new Rational(1, 1);

        return expected;
    }

    @Test
    public void testGenerateFarey() throws Exception {
        FareySequenceGeneratorArray actual = new FareySequenceGeneratorArray(4, 10);
        actual.generateFarey();

        Rational[] expected = getExpected();
        assertArrayEquals(expected, actual.getArray());
    }
}