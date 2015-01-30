/**
 * https://oj.leetcode.com/problems/edit-distance/
 * <p/>
 * Created by Penny on 18/1/15.
 */
public class EditDistance {
    /**
     * 参考：http://www.cnblogs.com/lihaozy/archive/2012/12/31/2840152.html
     * http://blog.csdn.net/huaweidong2011/article/details/7727482
     */
    public int minDistance(String word1, String word2) {
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        int[][] a = new int[row][col];
        for (int i = 0; i < row; i++)
            a[i][0] = i;
        for (int i = 0; i < col; i++)
            a[0][i] = i;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    a[i][j] = a[i - 1][j - 1];
                else
                    a[i][j] = a[i - 1][j - 1] + 1;
                a[i][j] = Math.min(a[i][j], Math.min(a[i - 1][j] + 1, a[i][j - 1] + 1));
            }
        }
        return a[row - 1][col - 1];
    }
}
