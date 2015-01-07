import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * <p/>
 * Created by Penny on 2014/12/11
 */
public class BinaryTreePostorderTraversal {
    /**
     * left-right-root
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();

        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }

        Collections.reverse(list);

        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        traversal(node.left, list);
        traversal(node.right, list);
        list.add(node.val);
    }
}
