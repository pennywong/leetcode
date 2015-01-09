import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 * <p/>
 * Created by Penny on 2015/01/08
 */
public class SetMatrixZeroes {
    /**
     * 只需先找到有0的行和列，综合一下，然后再将有0的行和列都设置成0
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rowSet = new HashSet<Integer>();
        Set<Integer> columnSet = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for (int i : rowSet)
            for (int k = 0; k < n; k++)
                matrix[i][k] = 0;

        for (int j : columnSet)
            for (int k = 0; k < m; k++)
                matrix[k][j] = 0;
    }
}
