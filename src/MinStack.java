import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/min-stack/
 * <p/>
 * Created by Penny on 2014/11/19 0019.
 */
public class MinStack {
    /**
     * 使用一个额外的stack来跟踪目前最小的值，要注意相同的数的处理
     */
    private Stack<Node> minStack = new Stack<Node>();
    private Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || minStack.peek().min > x) {
            Node node = new Node();
            node.min = x;
            node.count = 1;
            minStack.push(node);
        } else if (minStack.peek().min == x)
            minStack.peek().count++;
    }

    public void pop() {
        int x = stack.pop();
        if (x == minStack.peek().min) {
            minStack.peek().count--;
            if (minStack.peek().count == 0)
                minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek().min;
    }

    private class Node {
        int min;
        int count;
    }
}
