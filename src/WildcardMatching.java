/**
 * https://oj.leetcode.com/problems/wildcard-matching/
 * <p/>
 * Created by Penny on 2015/01/20
 */
public class WildcardMatching {
    /**
     * 参考：http://www.cnblogs.com/felixfang/p/3708999.html
     * http://xoomer.virgilio.it/acantato/dev/wildcard/wildmatch.html
     * http://blog.csdn.net/pickless/article/details/9787227
     */
    public boolean isMatch(String s, String p) {
        int preP = 0;
        int preS = 0;
        boolean star = false;

        int i = 0;
        int j = 0;
        while (i < s.length() && (j < p.length() || star)) {

            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
                continue;
            }

            if (j < p.length() && p.charAt(j) == '*') {
                star = true;
                j++;
                preP = j;
                preS = i;
                continue;
            }

            if (star) {
                preS++;
                i = preS;
                j = preP;
                continue;
            }

            return false;
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;
        return i == s.length() && j == p.length();
    }
}
