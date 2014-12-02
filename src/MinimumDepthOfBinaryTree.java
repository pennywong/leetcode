/**
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * <p/>
 * Created by Penny on 2014/11/24
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (root.left != null)
            left = minDepth(root.left) + 1;

        if (root.right != null)
            right = minDepth(root.right) + 1;

        return left <= right ? left : right;
    }

    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;

        return depth(root, 0);
    }

    private int depth(TreeNode node, int depth) {
        depth++;

        if (node.left == null && node.right == null)
            return depth;

        int leftDepth = Integer.MAX_VALUE;
        if (node.left != null)
            leftDepth = depth(node.left, depth);

        int rightDepth = Integer.MAX_VALUE;
        if (node.right != null)
            rightDepth = depth(node.right, depth);

        return leftDepth <= rightDepth ? leftDepth : rightDepth;
    }
}
