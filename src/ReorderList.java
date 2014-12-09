import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/reorder-list/
 * <p/>
 * Created by Penny on 2014/12/08
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        int n = 0;
        ListNode p = head;
        List<ListNode> list = new ArrayList<ListNode>();
        while (p != null) {
            n++;
            list.add(p);
            p = p.next;
        }

        p = head;
        ListNode q = list.get(n - 1);
        p.next = q;
        p = q;
        for (int i = 2; i <= n / 2; i++) {
            q = list.get(i - 1);
            p.next = q;
            p = q;

            q = list.get(n - i);
            p.next = q;
            p = q;
        }

        if (n % 2 != 0) {
            q = list.get(n / 2);
            p.next = q;
            p = q;
        }

        p.next = null;
    }
}
