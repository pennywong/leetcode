/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * <p/>
 * Created by Penny on 2015/01/15
 */
public class LongestPalindromicSubstring {
    /**
     * 参考：http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
     */
    public String longestPalindrome(String s) {
        int N = s.length();
        int start = 0;
        int maxLen = 1;

        boolean[][] table = new boolean[N][N];

        for (int i = 0; i < N; i++)
            table[i][i] = true;

        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 0; i < N - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
