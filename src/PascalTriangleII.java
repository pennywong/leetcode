import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 * <p/>
 * Created by Penny on 2014/11/20
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);

        for (int i = 0; i <= rowIndex; i++) {
            if (i > 0) {
                int pre = 1;
                for (int j = 1; j < i; j++) {
                    int temp = list.get(j);
                    list.set(j, temp + pre);
                    pre = temp;
                }
            }
            list.add(1);
        }

        return list;
    }
}
