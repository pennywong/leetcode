/**
 * https://oj.leetcode.com/problems/search-for-a-range/
 * <p/>
 * Created by Penny on 2015/01/16
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int index = search(A, target, 0, A.length);

        if (index == -1)
            return new int[]{-1, -1};

        int left = index;
        int right = index;

        while (left > 0) {
            index = search(A, target, 0, left);
            if (index == -1)
                break;
            left = index;
        }

        while (right < A.length) {
            index = search(A, target, right + 1, A.length);
            if (index == -1)
                break;
            right = index;
        }

        return new int[]{left, right};
    }

    private int search(int[] A, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (target == A[mid])
                return mid;

            if (target > A[mid])
                start = mid + 1;
            else
                end = mid;
        }

        return -1;
    }
}
