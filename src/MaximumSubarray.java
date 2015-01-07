/**
 * https://oj.leetcode.com/problems/maximum-subarray/
 * <p/>
 * Created by Penny on 2014/12/17
 */
public class MaximumSubarray {
    /**
     * 参考http://blog.csdn.net/u013195320/article/details/22385167
     */
    public int maxSubArray(int[] A) {
        int sum = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += A[i];

            if (max < sum)
                max = sum;
        }

        return max;
    }
}
