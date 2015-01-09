/**
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * <p/>
 * Created by Penny on 2015/01/08
 */
public class MinimumPathSum {
    /**
     * 和 https://oj.leetcode.com/problems/unique-paths/ 一样
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        int[][] a = new int[row][column];
        a[0][0] = grid[0][0];
        for (int i = 1; i < row; i++)
            a[i][0] = a[i - 1][0] + grid[i][0];
        for (int j = 1; j < column; j++)
            a[0][j] = a[0][j - 1] + grid[0][j];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                int min = a[i - 1][j] <= a[i][j - 1] ? a[i - 1][j] : a[i][j - 1];
                a[i][j] = min + grid[i][j];
            }
        }

        return a[row - 1][column - 1];
    }
}
