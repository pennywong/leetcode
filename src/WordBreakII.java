import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 * <p/>
 * Created by Penny on 2015/01/28
 */
public class WordBreakII {
    /**
     * 参考：http://www.cnblogs.com/easonliu/p/3680966.html
     * http://www.acmerblog.com/word-break-ii-6128.html?utm_source=tuicool
     */
    public List<String> wordBreak(String s, Set<String> dict) {
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

        List<String> list = new LinkedList<String>();
        if (dp[s.length()])
            wordBreak(s, dict, "", 0, dp, list);

        return list;
    }

    private void wordBreak(String s, Set<String> dict, String string, int index, boolean[] dp, List<String> list) {
        for (int i = index + 1; i <= s.length(); i++) {
            if (dp[i]) {
                String str = s.substring(index, i);
                if (dict.contains(str)) {
                    if (i >= s.length()) {
                        list.add(string + str);
                        return;
                    } else
                        wordBreak(s, dict, string + str + " ", i, dp, list);
                }
            }
        }
    }
}
