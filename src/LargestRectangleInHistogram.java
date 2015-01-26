import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * <p/>
 * Created by Penny on 2015/01/23
 */
public class LargestRectangleInHistogram {
    /**
     * 参考：https://oj.leetcode.com/discuss/8079/my-modified-answer-from-geeksforgeeks-in-java
     * http://blog.csdn.net/doc_sgl/article/details/11805519
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int h = stack.pop();
                int d = stack.isEmpty() ? i : (i - 1 - stack.peek());
                max = Math.max(max, height[h] * d);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int h = stack.pop();
            int d = stack.isEmpty() ? height.length : (height.length - 1 - stack.peek());
            max = Math.max(max, height[h] * d);
        }

        return max;
    }
}
