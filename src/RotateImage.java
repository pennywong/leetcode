/**
 * https://oj.leetcode.com/problems/rotate-image/
 * <p/>
 * Created by Penny on 2014/12/17
 */
public class RotateImage {
    /**
     * 第1次就是最外面的圈的一个旋转，第2次是里面1圈的选择，因为是对称的只要一半即可
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n / 2; row++) {
            for (int j = row; j < (n - row - 1); j++) {
                int x = matrix[row][j];
                matrix[row][j] = matrix[n - j - 1][row];
                matrix[n - j - 1][row] = matrix[n - row - 1][n - j - 1];
                matrix[n - row - 1][n - j - 1] = matrix[j][n - row - 1];
                matrix[j][n - row - 1] = x;
            }
        }
    }

    /**
     * 第一行转到最后一列，第二行转到倒数第2列，以此类推，参考：http://blog.csdn.net/friendan/article/details/8824682
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
