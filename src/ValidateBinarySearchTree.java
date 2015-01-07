import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * <p/>
 * Created by Penny on 2014/12/12
 */
public class ValidateBinarySearchTree {
    /**
     * Inorder traversal，从小到大则为有效
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        int val = 0;
        boolean started = false;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (started && val >= root.val)
                    return false;
                val = root.val;
                started = true;

                root = root.right;
            }
        }

        return true;
    }
}
