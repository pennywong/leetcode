/**
 * https://oj.leetcode.com/problems/search-a-2d-matrix/
 * <p/>
 * Created by Penny on 2015/01/08
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (target == matrix[mid][0])
                return true;
            else if (target < matrix[mid][0])
                right = mid;
            else {
                if (target <= matrix[mid][n - 1])
                    break;
                else
                    left = mid + 1;
            }
        }

        left = 0;
        right = n;
        int row = mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (target == matrix[row][mid])
                return true;
            else if (target < matrix[row][mid])
                right = mid;
            else
                left = mid + 1;
        }

        return false;
    }
}
