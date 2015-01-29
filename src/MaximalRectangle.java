import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/maximal-rectangle/
 * <p/>
 * Created by Penny on 2015/01/26
 */
public class MaximalRectangle {
    /**
     * 参考：http://blog.csdn.net/doc_sgl/article/details/11832965
     */
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int column = matrix[0].length;
        if (column == 0)
            return 0;
        int[][] dp = new int[row][column + 1];

        for (int i = 0; i < column; i++) {
            if (matrix[0][i] == '1')
                dp[0][i] = 1;
        }

        for (int j = 0; j < column; j++) {
            for (int i = 1; i < row; i++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = dp[i - 1][j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < row; i++) {
            int area = largestRectangleArea(dp[i]);
            if (max < area)
                max = area;
        }

        return max;
    }

    private int largestRectangleArea(int[] height) {
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

        return max;
    }
}
