/**
 * Created by Penny on 2014/11/25
 * <p/>
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    /**
     * 非常偷懒的做法
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;

        String[] strings = s.split(" ");
        if (strings.length == 0)
            return 0;

        return strings[strings.length - 1].length();
    }
}
