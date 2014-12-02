/**
 * https://oj.leetcode.com/problems/remove-element/
 * <p/>
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p/>
 * Created by Penny on 13/11/14.
 */
public class RemoveElement {
    /**
     * 不相等的时候右移索引
     *
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem) {
        if (A == null)
            return 0;

        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                index++;

                if (index != i)
                    A[index] = A[i];
            }
        }

        if (index == -1)
            return 0;
        else
            return index + 1;
    }
}
