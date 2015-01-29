/**
 * https://oj.leetcode.com/problems/decode-ways/
 * <p/>
 * Created by Penny on 2015/01/26
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c >= '1' && c <= '9')
                    dp[i] = 1;
            } else {
                Integer integer = Integer.parseInt(s.substring(i - 1, i + 1));
                if (integer >= 10 && integer <= 26) {
                    if (i > 1)
                        dp[i] += dp[i - 2];
                    else
                        dp[i] += 1;
                }
                if (c >= '1' && c <= '9')
                    dp[i] += dp[i - 1];
            }
        }

        return dp[s.length() - 1];
    }
}
