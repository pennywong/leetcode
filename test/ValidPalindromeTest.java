import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Penny on 2014/11/20
 */
@RunWith(Parameterized.class)
public class ValidPalindromeTest {
    private boolean expect;
    private String string;

    public ValidPalindromeTest(boolean expect, String string) {
        this.expect = expect;
        this.string = string;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{true, "A man, a plan, a canal: Panama"}, {false, "race a car"}});
    }

    @Test
    public void test() {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        assertEquals(expect, validPalindrome.isPalindrome(string));
    }
}
