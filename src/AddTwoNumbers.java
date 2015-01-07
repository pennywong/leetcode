/**
 * https://oj.leetcode.com/problems/add-two-numbers/
 * <p/>
 * Created by Penny on 2014/12/11
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else
                carry = 0;

            p.next = new ListNode(sum);
            p = p.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carry == 1)
            p.next = new ListNode(1);

        return dummyHead.next;
    }
}
