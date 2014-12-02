/**
 * https://oj.leetcode.com/problems/longest-common-prefix
 * <p/>
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int matchIndex = -1;
        for (int i = 0; i < strs[0].length(); i++) {
            char pre = strs[0].charAt(i);
            boolean result = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != pre) {
                    result = false;
                    break;
                }
            }

            if (result)
                matchIndex++;
            else
                break;
        }

        if (matchIndex == -1)
            return "";
        else
            return strs[0].substring(0, matchIndex + 1);
    }
}
