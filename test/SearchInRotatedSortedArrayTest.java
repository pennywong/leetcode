import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Penny on 2015/01/12
 */
@RunWith(Parameterized.class)
public class SearchInRotatedSortedArrayTest {
    private int expect;
    private int[] a;
    private int target;

    public SearchInRotatedSortedArrayTest(int expect, int[] a, int target) {
        this.expect = expect;
        this.a = a;
        this.target = target;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{1, new int[]{1, 3}, 3}, {1, new int[]{3, 1}, 1}});
    }

    @Test
    public void test() {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        assertEquals(expect, searchInRotatedSortedArray.search(a, target));
    }
}
