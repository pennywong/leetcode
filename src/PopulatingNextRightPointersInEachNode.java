import java.util.LinkedList;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class PopulatingNextRightPointersInEachNode {
    /**
     * 参考了本题的讨论
     */
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;

            connect(root.left);
            connect(root.right);
        }
    }

    public void connect2(TreeLinkNode root) {
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
