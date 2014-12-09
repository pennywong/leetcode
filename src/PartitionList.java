/**
 * https://oj.leetcode.com/problems/partition-list/
 * <p/>
 * Created by Penny on 2014/12/08
 */
public class PartitionList {
    /**
     * 拆分成小于和大于等于两个链表，然后再合并一下即可
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode small = null;
        ListNode large = null;
        ListNode smallP = null;
        ListNode largeP = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            if (p.val < x) {
                if (small == null)
                    small = p;
                else
                    smallP.next = p;

                smallP = p;
            } else {
                if (large == null)
                    large = p;
                else
                    largeP.next = p;

                largeP = p;
            }
            p.next = null;
            p = next;
        }

        if (small == null)
            return large;
        else {
            smallP.next = large;
            return small;
        }
    }
}
