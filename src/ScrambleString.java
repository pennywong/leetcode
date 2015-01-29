/**
 * https://oj.leetcode.com/problems/scramble-string/
 * <p/>
 * Created by Penny on 2015/01/26
 */
public class ScrambleString {
    /**
     * 参考：http://blog.csdn.net/pickless/article/details/11501443
     * http://www.cnblogs.com/easonliu/p/3696135.html
     * http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ascramble-string%EF%BC%8C%E4%B8%89%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int length = s1.length();
        if (length == 0)
            return true;

        boolean[][][] dp = new boolean[length][length][length];

        for (int k = 1; k <= length; k++) {
            for (int i = 0; i <= length - k; i++) {
                for (int j = 0; j <= length - k; j++) {
                    if (k == 1)
                        dp[i][j][k - 1] = (s1.charAt(i) == s2.charAt(j));
                    else {
                        for (int m = 1; m < k; m++) {
                            if (dp[i][j][m - 1] && dp[i + m][j + m][k - m - 1] || dp[i][j + k - m][m - 1] && dp[i + m][j][k - m - 1]) {
                                dp[i][j][k - 1] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0][length - 1];
    }
}
