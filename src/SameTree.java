import java.util.LinkedList;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/same-tree/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1 == null && node2 == null)
                continue;

            if (node1 == null && node2 != null || node1 != null && node2 == null)
                return false;

            if (node1.val != node2.val)
                return false;

            queue1.add(node1.left);
            queue1.add(node1.right);

            queue2.add(node2.left);
            queue2.add(node2.right);

        }

        return queue1.isEmpty() && queue2.isEmpty() ? true : false;
    }
}
