/**
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 * <p/>
 * Created by Penny on 2014/11/24
 */
public class BalancedBinaryTree {
    /**
     * 感觉实现不太好，有点罗嗦
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if (left == -1 || right == -1)
            return false;

        if (Math.abs(left - right) <= 1)
            return true;
        else
            return false;
    }

    int depth(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        int left = depth(node.left);
        int right = depth(node.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) <= 1)
            return left >= right ? left + 1 : right + 1;
        else
            return -1;
    }
}
