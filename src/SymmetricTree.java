/**
 * https://oj.leetcode.com/problems/symmetric-tree/
 * <p/>
 * Created by Penny on 2014/11/20
 */
public class SymmetricTree {
    /**
     * 按层次进行访问，一个节点的左节点要等于另外一个节点的右节点，它的右节点要等于另外一个节点的左节点
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        if ((node1 == null && node2 != null) || (node1 != null && node2 == null))
            return false;

        if (node1.val != node2.val)
            return false;

        if (compare(node1.left, node2.right))
            return compare(node1.right, node2.left);
        else
            return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
