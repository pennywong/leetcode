import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        traversal(root, 0, result);

        List<List<Integer>> reverse = new LinkedList<List<Integer>>();
        for (int i = result.size() - 1; i >= 0; i--)
            reverse.add(result.get(i));

        return reverse;
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
