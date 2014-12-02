import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        traversal(root, 0, result);
        return result;
    }

    private void traversal(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null)
            return;

        List<Integer> list;
        if (depth >= result.size()) {
            list = new LinkedList<Integer>();
            result.add(list);
        } else
            list = result.get(depth);

        list.add(node.val);

        traversal(node.left, depth + 1, result);
        traversal(node.right, depth + 1, result);
    }
}
