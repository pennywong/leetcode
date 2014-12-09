/**
 * https://oj.leetcode.com/problems/reverse-words-in-a-string/
 * <p/>
 * Created by Penny on 2014/12/02
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null)
            return null;

        s = s.trim();

        String[] strings = s.split("\\s+");

        if (strings.length == 0)
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
