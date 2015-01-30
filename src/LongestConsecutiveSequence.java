import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * <p/>
 * Created by Penny on 11/1/15.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++)
            map.put(num[i], num[i]);

        int max = 0;

        for (int i = 0; i < num.length; i++) {
            if (map.get(num[i]) != null) {
                map.remove(num[i]);
                int sum = 1;

                int next = num[i] + 1;
                while (map.get(next) != null) {
                    sum++;
                    map.remove(next);
                    next++;
                }

                next = num[i] - 1;
                while (map.get(next) != null) {
                    sum++;
                    map.remove(next);
                    next--;
                }

                if (max < sum)
                    max = sum;
            }
        }

        return max;
    }
}
