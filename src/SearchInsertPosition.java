/**
 * https://oj.leetcode.com/problems/search-insert-position/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= target)
                return i;
        }

        return A.length;
    }
}
