/**
 * https://oj.leetcode.com/problems/minimum-window-substring/
 * <p/>
 * Created by Penny on 2015/01/23
 */
public class MinimumWindowSubstring {
    /**
     * 参考：https://oj.leetcode.com/discuss/10337/accepted-o-n-solution
     */
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0 || S.length() < T.length())
            return "";

        int count = T.length();
        int[] required = new int[128];
        boolean[] check = new boolean[128];
        for (int i = 0; i < count; i++) {
            required[T.charAt(i)]++;
            check[T.charAt(i)] = true;
        }

        int i = -1;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        while (i < S.length() && j < S.length()) {
            if (count > 0) {
                i++;
                if (i < S.length()) {
                    int c = S.charAt(i);
                    required[c]--;
                    if (check[c] && required[c] >= 0)
                        count--;
                }
            } else {
                if (min > (i - j + 1)) {
                    min = i - j + 1;
                    minIndex = j;
                }
                int c = S.charAt(j);
                required[c]++;
                if (check[c] && required[c] > 0)
                    count++;
                j++;
            }
        }

        if (min == Integer.MAX_VALUE)
            return "";

        return S.substring(minIndex, minIndex + min);
    }
}
