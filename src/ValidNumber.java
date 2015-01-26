/**
 * https://oj.leetcode.com/problems/valid-number/
 * <p/>
 * Created by Penny on 2015/01/22
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;
        s = s.trim();
        try {
            Double d = Double.parseDouble(s);
            char c = s.charAt(s.length() - 1);
            if (c >= '0' && c <= '9' || c == '.')
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
