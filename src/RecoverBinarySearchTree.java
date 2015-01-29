/**
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 * <p/>
 * Created by Penny on 2015/01/27
 */
public class RecoverBinarySearchTree {
    /**
     * 参考：http://blog.163.com/ya_mzy/blog/static/19959325520137153340725/
     */
    private TreeNode node1;
    private TreeNode node2;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        find(root);

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void find(TreeNode root) {
        if (root.left != null)
            find(root.left);
        if (pre != null) {
            if (pre.val > root.val) {
                if (node1 == null) {
                    node1 = pre;
                    node2 = root;
                } else
                    node2 = root;
            }
        }

        pre = root;

        if (root.right != null)
            find(root.right);
    }
}
