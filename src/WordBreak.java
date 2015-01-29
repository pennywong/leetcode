import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break/
 * <p/>
 * Created by Penny on 2015/01/28
 */
public class WordBreak {
    /**
     * 参考：http://blog.csdn.net/xin_jmail/article/details/39161431
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
