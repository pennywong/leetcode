/**
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 * <p/>
 * Implement atoi to convert a string to an integer.
 * <p/>
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * <p/>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * <p/>
 * <p/>
 * Requirements for atoi: The function first discards as many whitespace
 * characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus
 * sign followed by as many numerical digits as possible, and interprets them as
 * a numerical value.
 * <p/>
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * <p/>
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * <p/>
 * If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX
 * (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * @author Penny
 */
public class StringToInteger {
    /**
     * 注意各种情况：
     * <p/>
     * 1.去掉首尾的空字符
     * <p/>
     * 2.前面除了+或-的符号位之外，不能有其他字符
     * <p/>
     * 3.数字后面的其他字符忽略
     * <p/>
     * 4.超过INT_MAX或INT_MIN，返回最大值或最小值
     */
    public int atoi(String str) {
        if (str == null)
            return 0;

        str = str.trim();

        if (str.length() == 0)
            return 0;

        char symbol = str.charAt(0);
        if ((symbol < '0' || symbol > '9') && !(symbol == '-' || symbol == '+'))
            return 0;

        int end = str.length();
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                end = i;
                break;
            }
        }

        try {
            Long l = Long.parseLong(str.substring(0, end));
            if (l > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (l < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            return l.intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
