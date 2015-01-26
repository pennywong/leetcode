import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 * <p/>
 * Created by Penny on 2015/01/20
 */
public class LongestValidParentheses {
    /**
     * 参考：http://www.cnblogs.com/easonliu/p/3637429.html
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;

        boolean[] a = new boolean[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (!stack.isEmpty()) {
                a[i] = true;
                a[stack.pop()] = true;
            }
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (a[i])
                sum++;
            else
                sum = 0;
            max = Math.max(max, sum);
        }

        return max;
    }
}
