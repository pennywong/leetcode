import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p/>
 * Created by Penny on 2014/12/12
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<Integer>();
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }

            if (reverse)
                Collections.reverse(list);
            result.add(list);
            reverse = !reverse;
            queue = nextLevel;
        }

        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reverse = false;
        queue.add(root);
        queue.add(null);
        List<Integer> list = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            } else {
                if (reverse)
                    Collections.reverse(list);
                result.add(list);

                if (!queue.isEmpty()) {
                    list = new LinkedList<Integer>();
                    queue.add(null);
                    reverse = !reverse;
                }
            }
        }

        return result;
    }
}
