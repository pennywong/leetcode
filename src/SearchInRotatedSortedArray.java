/**
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * <p/>
 * Created by Penny on 2014/12/12
 */
public class SearchInRotatedSortedArray {
    /**
     * 参考：https://oj.leetcode.com/discuss/5707/algorithm-using-binary-search-accepted-some-suggestions-else
     */
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == A[mid])
                return mid;

            if (A[left] <= A[mid]) {
                if (target >= A[left] && target <= A[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (target >= A[mid] && target <= A[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }
}
