import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/spiral-matrix/
 * <p/>
 * Created by Penny on 2015/01/09
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer>();

        if (matrix == null || matrix.length == 0)
            return list;

        int row = matrix.length - 1;
        int column = matrix[0].length - 1;

        for (int i = 0, j = 0; i <= row / 2 && j <= column / 2; i++, j++)
            spiralOrder(matrix, row - i, column - j, i, j, list);

        return list;
    }

    private void spiralOrder(int[][] matrix, int row, int column, int i, int j, List<Integer> list) {
        for (int k = j; k <= column; k++)
            list.add(matrix[i][k]);

        for (int k = i + 1; k <= row; k++)
            list.add(matrix[k][column]);

        if (i != row) {
            for (int k = column - 1; k >= j; k--)
                list.add(matrix[row][k]);
        }

        if (j != column) {
            for (int k = row - 1; k > i; k--)
                list.add(matrix[k][j]);
        }
    }
}
