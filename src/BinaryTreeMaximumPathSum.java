/**
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * <p/>
 * Created by Penny on 2015/01/27
 */
public class BinaryTreeMaximumPathSum {
    /**
     * 参考：http://www.cnblogs.com/x1957/p/3275854.html
     * http://www.cnblogs.com/luweiseu/p/3149164.html
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        sum(root);
        return max;
    }

    private int sum(TreeNode root) {
        if (root == null)
            return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        int val = root.val;
        if (left > 0)
            val += left;
        if (right > 0)
            val += right;
        if (val > max)
            max = val;
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }
}
