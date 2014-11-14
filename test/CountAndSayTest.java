import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountAndSayTest {
    private String expect;
    private int n;

    public CountAndSayTest(String expect, int n) {
        this.expect = expect;
        this.n = n;
    }

    @Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{null, 0}, {"1", 1},
                {"11", 2}, {"21", 3}, {"1211", 4}, {"111221", 5},
                {"312211", 6}});
    }

    @Test
    public void test() {
        CountAndSay countAndSay = new CountAndSay();
        assertEquals(expect, countAndSay.countAndSay(n));
    }

}
