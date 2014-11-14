import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedArrayTest {
    private int expect;
    private int[] array;

    public RemoveDuplicatesFromSortedArrayTest(int expect, int[] array) {
        this.expect = expect;
        this.array = array;
    }

    @Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{0, null}, {0, new int[]{}},
                {1, new int[]{1}}, {1, new int[]{1, 1}},
                {2, new int[]{1, 1, 2, 2}},});
    }

    @Test
    public void test() {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        assertEquals(expect,
                removeDuplicatesFromSortedArray.removeDuplicates(array));
    }

}
