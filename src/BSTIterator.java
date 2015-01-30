import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-search-tree-iterator/
 * <p/>
 * Created by Penny on 11/1/15.
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        addNode(root);
    }

    private void addNode(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        addNode(node.right);
        return node.val;
    }
}
