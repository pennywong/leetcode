/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p/>
 * Created by Penny on 2014/12/09
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(0);
        ListNode node = newHead;

        ListNode p = head;
        while (p != null) {
            int count = 0;
            ListNode q = p.next;
            while (q != null && p.val == q.val) {
                count++;
                q = q.next;
            }

            if (count == 0) {
                node.next = p;
                node = p;
            }

            p = q;
        }

        node.next = null;

        return newHead.next;
    }
}
