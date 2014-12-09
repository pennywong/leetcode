/**
 * https://oj.leetcode.com/problems/rotate-list/
 * <p/>
 * Created by Penny on 2014/12/08
 */
public class RotateList {
    /**
     * 参考：http://www.xuebuyuan.com/1920183.html
     * 题目是一个循环右移操作
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            len++;
            p = p.next;
        }

        n = n % len;
        if (n == 0)
            return head;

        // 变成一个环
        p.next = head;

        p = head;
        for (int i = 0; i < len - n - 1; i++)
            p = p.next;

        head = p.next;
        p.next = null;

        return head;
    }
}
