import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/valid-parentheses/
 * <p/>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    /**
     * 符号匹配，使用堆栈即可，遇到左边符号的入栈，遇到右边符号的出栈，如果两个符号不相等则不匹配
     * <p/>
     * 只要主要边界情况即可，如1个符号，()], ()(等
     */
    public boolean isValid(String s) {
        if (s == null || s.equals(""))
            return false;

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (stack.isEmpty())
                return false;
            else {
                char x = stack.pop();
                if (c == ')' && x != '(')
                    return false;
                else if (c == '}' && x != '{')
                    return false;
                else if (c == ']' && x != '[')
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
