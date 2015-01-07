import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/single-number-ii/
 * <p/>
 * Created by Penny on 2014/12/09
 */
public class SingleNumberII {
    /**
     * 参考本题讨论
     */
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for (int i = 0; i < A.length; i++) {
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

    public int singleNumber2(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            Integer times = map.get(A[i]);
            if (times == null)
                map.put(A[i], 1);
            else {
                if (times == 2)
                    map.remove(A[i]);
                else
                    map.put(A[i], 2);
            }
        }

        return map.keySet().iterator().next();
    }
}
