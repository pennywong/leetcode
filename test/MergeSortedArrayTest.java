import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Penny on 2014/11/25
 */
public class MergeSortedArrayTest {
    private MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @Test
    public void testNull() {
        int[] A = null;
        int[] B = null;

        mergeSortedArray.merge(A, 0, B, 0);
        assertNull(A);
    }

    @Test
    public void testOneNull() {
        int[] A = new int[3];
        int[] B = new int[]{0, 1};
        mergeSortedArray.merge(A, 0, B, 2);

        int[] expect = new int[3];
        expect[0] = 0;
        expect[1] = 1;

        assertArrayEquals(expect, A);
    }
}
