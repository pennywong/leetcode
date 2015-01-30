/**
 * https://oj.leetcode.com/problems/distinct-subsequences/
 * <p/>
 * Created by Penny on 18/1/15.
 */
public class DistinctSubsequences {
    /**
     * 参考：http://blog.csdn.net/worldwindjp/article/details/19770281
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length())
            return 0;
        int[][] a = new int[S.length() + 1][T.length() + 1];
        a[0][0] = 1;
        for (int i = 1; i < S.length(); i++)
            a[i][0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                a[i][j] = a[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    a[i][j] += a[i - 1][j - 1];
                }
            }
        }

        return a[S.length()][T.length()];
    }
}
