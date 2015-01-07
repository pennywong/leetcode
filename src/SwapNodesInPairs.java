/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * <p/>
 * Created by Penny on 2014/12/12
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        while (head != null && head.next != null) {
            ListNode q1 = head;
            ListNode q2 = head.next;
            head = head.next.next;

            p.next = q2;
            q2.next = q1;
            p = q1;
        }

        p.next = head;

        return dummyHead.next;
    }
}
