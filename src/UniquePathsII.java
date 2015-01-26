/**
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * <p/>
 * Created by Penny on 2015/01/22
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;

        int[][] a = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (flag || obstacleGrid[i][0] == 1) {
                a[i][0] = 0;
                flag = true;
            } else
                a[i][0] = 1;
        }

        flag = false;
        for (int i = 0; i < n; i++) {
            if (flag || obstacleGrid[0][i] == 1) {
                a[0][i] = 0;
                flag = true;
            } else
                a[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    a[i][j] = 0;
                else
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
            }

        }
        return a[m - 1][n - 1];
    }
}
