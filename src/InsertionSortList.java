/**
 * https://oj.leetcode.com/problems/insertion-sort-list/
 * <p/>
 * Created by Penny on 2014/12/08
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode q = head.next;
        head.next = null;
        while (q != null) {
            ListNode next = q.next;
            q.next = null;
            ListNode p = head;
            ListNode pre = null;

            while (p != null && p.val <= q.val) {
                pre = p;
                p = p.next;
            }

            // head
            if (pre == null) {
                head = q;
                q.next = p;
            }
            // tail
            else if (p == null) {
                pre.next = q;
            }
            // middle
            else {
                pre.next = q;
                q.next = p;
            }

            q = next;
        }

        return head;
    }
}
