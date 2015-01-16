/**
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * <p/>
 * Created by Penny on 2015/01/15
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int[] a = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < a.length; k++) {
            int x = i < A.length ? A[i] : Integer.MAX_VALUE;
            int y = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (x <= y) {
                a[k] = x;
                i++;
            } else {
                a[k] = y;
                j++;
            }
        }

        int k = a.length / 2;
        if (a.length % 2 == 0)
            return (a[k - 1] + a[k]) * 1.0 / 2;
        else
            return a[k];
    }
}
