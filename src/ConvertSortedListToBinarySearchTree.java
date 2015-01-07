/**
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return new TreeNode(head.val);

        ListNode mid = getMid(head);

        TreeNode root = new TreeNode(mid.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode getMid(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;
        while (p != null && q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }

        if (pre != null)
            pre.next = null;

        return p;
    }
}
