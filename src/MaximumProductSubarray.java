/**
 * https://oj.leetcode.com/problems/maximum-product-subarray/
 * <p/>
 * Created by Penny on 2015/01/29
 */
public class MaximumProductSubarray {
    /**
     * 参考：http://www.cnblogs.com/bakari/p/4007368.html
     */
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int max = A[0];
        int min = A[0];
        int result = A[0];

        for (int i = 1; i < A.length; i++) {
            int tmin = A[i] * min;
            int tmax = A[i] * max;
            min = Math.min(A[i], Math.min(tmax, tmin));
            max = Math.max(A[i], Math.max(tmax, tmin));
            result = Math.max(result, max);
        }

        return result;
    }
}
