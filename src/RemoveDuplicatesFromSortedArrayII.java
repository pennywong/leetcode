/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * <p/>
 * Created by Penny on 2014/12/09
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int index = 0;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[index] == A[i]) {
                count++;
                if (count <= 2) {
                    index++;
                    A[index] = A[i];
                }
            } else {
                index++;
                A[index] = A[i];
                count = 1;
            }
        }

        return index + 1;
    }
}
