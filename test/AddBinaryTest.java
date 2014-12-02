import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Penny on 2014/11/25
 */
@RunWith(Parameterized.class)
public class AddBinaryTest {
    private String expect;
    private String a;
    private String b;

    public AddBinaryTest(String expect, String a, String b) {
        this.expect = expect;
        this.a = a;
        this.b = b;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{null, null, null}, {"1", null, "1"},
                {"1", "1", null}, {"1", "0", "1"}, {"10", "1", "1"}, {"11", "10", "1"},
                {"11", "1", "10"}, {"110", "11", "11"}});
    }

    @Test
    public void test() {
        AddBinary addBinary = new AddBinary();
        assertEquals(expect, addBinary.addBinary(a, b));
    }
}
