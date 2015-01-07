/**
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num.length == 0)
            return Integer.MIN_VALUE;

        int l = 0;
        int h = num.length - 1;

        while (l < h) {
            int mid = (l + h) / 2;
            if (num[mid] > num[h])
                l = mid + 1;
            else
                h = mid;
        }

        return num[l];
    }

    public int findMin2(int[] num) {
        if (num.length == 0)
            return Integer.MIN_VALUE;

        int min = num[0];
        for (int i = 1; i < num.length; i++)
            if (num[i] < min)
                min = num[i];

        return min;
    }
}
