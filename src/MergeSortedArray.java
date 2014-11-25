/**
 * https://oj.leetcode.com/problems/merge-sorted-array/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1, i = m - 1, j = n - 1;
        for (; index >= 0 && i >= 0 && j >= 0; index--) {
            if (A[i] == B[j]) {
                A[index] = A[i];
                index--;
                A[index] = A[i];
                i--;
                j--;
            } else if (A[i] < B[j]) {
                A[index] = B[j];
                j--;
            } else {
                A[index] = A[i];
                i--;
            }
        }

        while (i >= 0) {
            A[index] = A[i];
            index--;
            i--;
        }

        while (j >= 0) {
            A[index] = B[j];
            index--;
            j--;
        }
    }
}
