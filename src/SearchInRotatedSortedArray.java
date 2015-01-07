/**
 * Created by Penny on 2014/12/12
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }

    public int search2(int[] A, int target) {
        for (int i = 0; i < A.length; i++)
            if (target == A[i])
                return i;
        return -1;
    }

    private int search(int[] A, int target, int l, int h) {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (A[mid] == target)
            return mid;

        if (A[l] < A[mid] && target >= A[l] && target < A[mid] || A[l] > A[mid] && target <= A[l] && target > A[mid])
            return search(A, target, l, mid - 1);

        if (A[mid] < A[h] && target > A[mid] && target <= A[h] || A[mid] > A[h] && target < A[mid] && target >= A[h])
            return search(A, target, mid + 1, h);

        return -1;
    }
}
