/**
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = 1, right = 1;

        if (root.left != null)
            left += maxDepth(root.left);

        if (root.right != null)
            right += maxDepth(root.right);

        return left >= right ? left : right;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;

        return depth(root, 0);
    }

    private int depth(TreeNode node, int depth) {
        depth++;

        if (node.left == null && node.right == null)
            return depth;

        int leftDepth = Integer.MIN_VALUE;
        if (node.left != null)
            leftDepth = depth(node.left, depth);

        int rightDepth = Integer.MIN_VALUE;
        if (node.right != null)
            rightDepth = depth(node.right, depth);

        return leftDepth >= rightDepth ? leftDepth : rightDepth;
    }
}
