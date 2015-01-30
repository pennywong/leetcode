import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/maximum-gap/
 * <p/>
 * Created by Penny on 28/1/15.
 */
public class MaximumGap {
    public int maximumGap(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        Arrays.sort(num);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i] - num[i - 1]);
        }

        return max;
    }
}
