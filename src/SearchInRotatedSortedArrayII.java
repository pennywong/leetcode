/**
 * Created by Penny on 2015/01/12
 */
public class SearchInRotatedSortedArrayII {
    /**
     * 参考第一题的做法，但有相同的时候，先把相同的去掉
     */
    public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == A[mid])
                return true;

            if (A[left] == A[mid]) {
                while (left <= mid && A[left] == A[mid])
                    left++;
            }

            if (left > mid)
                left = mid + 1;
            else {
                if (A[left] < A[mid]) {
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
        }

        return false;
    }
}
