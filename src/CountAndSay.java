/**
 * https://oj.leetcode.com/problems/count-and-say/
 * <p/>
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 *
 * @author Penny 2014/11/14
 */
public class CountAndSay {
    /**
     * 根据上一个产生的字符串进行数数，多少个数字，相同的累加数量[多少个什么数字]
     * <p/>
     * 例如1，则下一个数得1个1，则'11'，然后再一个数得2个1，则'21'，再下一个数得1个2和1个1，则'1211'，如此类推
     */
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            char c = str.charAt(0);
            int count = 1;

            for (int j = 1; j < str.length(); j++) {
                if (c == str.charAt(j))
                    count++;
                else {
                    sb.append(count).append(c);
                    c = str.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(c);

            str = sb.toString();
        }

        return str;
    }
}
