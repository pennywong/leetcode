/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode q = head;
        ListNode p = head.next;

        while (p != null) {
            if (q.val != p.val) {
                q.next = p;
                q = p;
            }

            p = p.next;
        }

        q.next = null;

        return head;
    }
}
