/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p/>
 * Created by Penny on 2015/01/12
 */
public class FindMinimumInRotatedSortedArrayII {
    /**
     * 参考：http://www.cnblogs.com/ganganloveu/p/4081483.html
     */
    public int findMin(int[] num) {
        if (num.length == 0)
            return Integer.MIN_VALUE;

        if (num.length == 1)
            return num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i - 1] > num[i])
                return num[i];
        }
        return num[0];
    }
}
