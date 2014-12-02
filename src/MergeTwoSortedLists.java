/**
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode root;
        ListNode p1 = l1;
        ListNode p2 = l2;

        if (l1.val <= l2.val) {
            root = l1;
            p1 = l1.next;
        } else {
            root = l2;
            p2 = l2.next;
        }
        ListNode q = root;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                q.next = p1;
                q = p1;
                p1 = p1.next;
            } else {
                q.next = p2;
                q = p2;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            q.next = p1;
            q = p1;
            p1 = p1.next;
        }

        while (p2 != null) {
            q.next = p2;
            q = p2;
            p2 = p2.next;
        }

        q.next = null;

        return root;
    }
}
