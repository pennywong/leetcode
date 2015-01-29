/**
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * <p/>
 * Created by Penny on 2015/01/29
 */
public class PalindromePartitioningII {
    /**
     * 参考：http://blog.csdn.net/yutianzuijin/article/details/16850031
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] count = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            count[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count[i] = Math.min(count[i], count[j + 1] + 1);
                }
            }
        }
        return count[0] - 1;
    }
}
