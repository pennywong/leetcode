import org.junit.Test;

import java.util.List;

/**
 * Created by Penny on 2014/11/20
 */
public class PascalTriangleTest {
    @Test
    public void test() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> lists = pascalTriangle.generate(5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
