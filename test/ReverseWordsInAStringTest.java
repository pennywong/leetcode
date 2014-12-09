import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Penny on 2014/12/02
 */
@RunWith(Parameterized.class)
public class ReverseWordsInAStringTest {
    private String expect;
    private String s;

    public ReverseWordsInAStringTest(String expect, String s) {
        this.expect = expect;
        this.s = s;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{null, null}, {"", " "},
                {"1", " 1"}});
    }

    @Test
    public void test() {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        assertEquals(expect, reverseWordsInAString.reverseWords(s));
    }
}
