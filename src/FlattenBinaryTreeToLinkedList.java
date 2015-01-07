import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p/>
 * Created by Penny on 2014/12/12
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode p = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

            p.right = node;
            p = node;
            node.left = null;
        }

        p.right = null;
    }
}
