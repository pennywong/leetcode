/**
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * <p/>
 * Created by Penny on 2014/11/24
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
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
