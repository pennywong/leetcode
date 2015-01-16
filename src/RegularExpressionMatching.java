/**
 * https://oj.leetcode.com/problems/regular-expression-matching/
 * <p/>
 * Created by Penny on 2015/01/15
 */
public class RegularExpressionMatching {
    /**
     * 参考：http://blog.csdn.net/pickless/article/details/9043389
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;

        if (p.length() > 1 && p.charAt(1) == '*') {
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i), p.substring(2)))
                    return true;
                i++;
            }
            return isMatch(s.substring(i), p.substring(2));
        } else {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1), p.substring(1));
            return false;
        }
    }
}
