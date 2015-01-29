import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * <p/>
 * Created by Penny on 2015/01/28
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
                stack.push(calculate(stack.pop(), stack.pop(), token));
            else
                stack.push(Integer.parseInt(token));
        }

        if (stack.isEmpty())
            return 0;
        else
            return stack.pop();
    }

    private int calculate(int a, int b, String op) {
        if (op.equals("+"))
            return b + a;

        if (op.equals("-"))
            return b - a;

        if (op.equals("*"))
            return b * a;

        if (op.equals("/"))
            return b / a;

        return 0;
    }
}
