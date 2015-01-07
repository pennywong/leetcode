import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * <p/>
 * Created by Penny on 2014/12/11
 */
public class BinaryTreeInorderTraversal {
    /**
     * left-root-right
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();

        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }
}
