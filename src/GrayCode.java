import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/gray-code/
 * <p/>
 * Created by Penny on 2015/01/07
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        int length = (int) Math.pow(2, n);
        List<Integer> list = new ArrayList<Integer>(length);
        list.add(0, 0);

        int index = 1;
        for (int i = 1; i <= n; i++) {
            int end = (int) Math.pow(2, i);
            int diff = (int) Math.pow(2, i - 1);
            int offset = 1;
            while (index < end) {
                list.add(index, list.get(index - offset) + diff);
                index++;
                offset += 2;
            }
        }

        return list;
    }
}
