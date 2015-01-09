/**
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 * <p/>
 * Created by Penny on 2015/01/09
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[0][0];

        int[][] matrix = new int[n][n];
        int index = 1;
        for (int i = 0; i <= n / 2; i++)
            index = generateMatrix(matrix, n - i - 1, i, index);

        return matrix;
    }

    private int generateMatrix(int[][] matrix, int n, int i, int index) {
        for (int k = i; k <= n; k++, index++)
            matrix[i][k] = index;

        for (int k = i + 1; k <= n; k++, index++)
            matrix[k][n] = index;

        for (int k = n - 1; k >= i; k--, index++)
            matrix[n][k] = index;

        for (int k = n - 1; k > i; k--, index++)
            matrix[k][i] = index;

        return index;
    }
}
