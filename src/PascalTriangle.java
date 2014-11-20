import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle/
 * <p/>
 * Created by Penny on 2014/11/20
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);

        List<Integer> pre = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(i);
            if (i == 1) {
                list.add(1);
            } else {
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1)
                        list.add(1);
                    else
                        list.add(pre.get(j - 1) + pre.get(j));
                }
            }

            result.add(list);
            pre = list;
        }

        return result;
    }
}
