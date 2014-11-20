import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Penny on 2014/11/19 0019.
 */

public class MinStackTest {
    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.getMin());
    }
}
