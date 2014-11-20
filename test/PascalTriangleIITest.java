import org.junit.Test;

import java.util.List;

/**
 * Created by Penny on 2014/11/20
 */
public class PascalTriangleIITest {
    @Test
    public void test() {
        PascalTriangleII pascalTriangle = new PascalTriangleII();
        List<Integer> list = pascalTriangle.getRow(3);
        System.out.println(list);
    }
}
