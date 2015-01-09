import java.util.LinkedList;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * <p/>
 * Created by Penny on 2015/01/08
 */
public class PopulatingNextRightPointersInEachNodeII {
    /**
     * 层次遍历顺序，前面的指向后面的，但最后一个指向NULL即可
     */
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        // 每一层最后加一个NULL
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);
        TreeLinkNode pre = null;

        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();

            if (pre != null)
                pre.next = node;
            pre = node;

            if (node != null) {
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            } else if (!queue.isEmpty()) {
                queue.add(null);
            }
        }
    }
}
