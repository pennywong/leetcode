import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * <p/>
 * Created by Penny on 2014/12/11
 */
public class BinaryTreePreorderTraversal {
    /**
     * root-left-right
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();

        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }

        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        list.add(node.val);
        traversal(node.left, list);
        traversal(node.right, list);
    }
}
