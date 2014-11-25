/**
 * https://oj.leetcode.com/problems/path-sum/
 * <p/>
 * Created by Penny on 2014/11/24
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return doSum(root, sum);
    }

    private boolean doSum(TreeNode node, int sum) {
        sum = sum - node.val;

        if (node.left == null && node.right == null && sum == 0)
            return true;

        if (node.left != null && doSum(node.left, sum))
            return true;

        if (node.right != null && doSum(node.right, sum))
            return true;

        return false;
    }
}
