/**
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * <p/>
 * Created by Penny on 2015/01/16
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode dummyHead = new ListNode(0);
        ListNode reverse = dummyHead;

        ListNode p = head;
        ListNode q = null;
        ListNode tail = p;
        int count = 0;
        while (p != null) {
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;

            count++;
            if (count == k) {
                count = 0;
                reverse.next = q;
                q = null;
                reverse = tail;
                tail = p;
            }
        }

        if (count > 0) {
            p = q;
            q = null;
            while (p != null) {
                ListNode temp = p.next;
                p.next = q;
                q = p;
                p = temp;
            }
        }
        if (reverse != null)
            reverse.next = q;

        return dummyHead.next;
    }
}
