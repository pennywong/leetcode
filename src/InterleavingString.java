/**
 * https://oj.leetcode.com/problems/interleaving-string/
 * <p/>
 * Created by Penny on 2015/01/27
 */
public class InterleavingString {
    /**
     * 参考：http://blog.csdn.net/xin_jmail/article/details/39119731
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s3.length() != (s1.length() + s2.length()))
            return false;

        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++)
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);

        for (int i = 1; i <= n; i++)
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                dp[i][j] = (c == s1.charAt(i - 1) && dp[i - 1][j]) || (c == s2.charAt(j - 1) && dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
