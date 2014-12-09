/**
 * https://oj.leetcode.com/problems/sort-list/
 * <p/>
 * Created by Penny on 2014/12/09
 */
public class SortList {
    /**
     * 参考：http://blog.csdn.net/jiadebin890724/article/details/21334059
     * <p/>
     * 使用合并排序，使用fast-slow方法找中间数（http://baike.baidu.com/link?url=vADvd98YJRk3InLKB6hwPKFOVnWeq2P6p8wRTE24KkcySzhCOjP7iLr98TLlW72BOBglcb-DEdLdMFY59xJDQ_）
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(p);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }

            p = p.next;
        }

        while (left != null) {
            p.next = left;
            left = left.next;
            p = p.next;
        }

        while (right != null) {
            p.next = right;
            right = right.next;
            p = p.next;
        }

        p = dummyHead.next;
        dummyHead.next = null;
        return p;
    }
}
