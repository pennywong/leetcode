import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/single-number/
 * <p/>
 * Created by Penny on 2014/12/09
 */
public class SingleNumber {
    /**
     * 参考了本题的讨论，使用异或方法
     */
    public int singleNumber(int[] A) {
        int val = A[0];

        for (int i = 1; i < A.length; i++)
            val = val ^ A[i];

        return val;
    }

    public int singleNumber2(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]))
                map.remove(A[i]);
            else
                map.put(A[i], A[i]);
        }

        return map.keySet().iterator().next();
    }
}
