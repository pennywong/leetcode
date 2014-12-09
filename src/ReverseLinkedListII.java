/**
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * <p/>
 * Created by Penny on 2014/12/08
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode p = head;
        ListNode pre = null;

        while (count < m) {
            pre = p;
            p = p.next;
            count++;
        }

        ListNode q = p;
        p = p.next;
        ListNode tail = q;
        q.next = null;
        while (count < n) {
            ListNode next = p.next;
            p.next = q;
            q = p;
            p = next;
            count++;
        }

        if (pre == null)
            head = q;
        else
            pre.next = q;

        tail.next = p;

        return head;
    }
}
