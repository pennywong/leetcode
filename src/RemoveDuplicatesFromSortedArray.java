/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * <p/>
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * <p/>
 * For example, Given input array A = [1,1,2],
 * <p/>
 * Your function should return length = 2, and A is now [1,2].
 *
 * @author Penny on 2014/11/14
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[index] != A[i]) {
                index++;
                if (index != i)
                    A[index] = A[i];
            }
        }

        return index + 1;
    }
}
