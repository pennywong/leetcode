import java.util.HashMap;
import java.util.Map;

/**
 * Created by Penny on 2014/12/02
 * <p/>
 * https://oj.leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    /**
     * 参考https://github.com/haoel/leetcode/blob/master/src/linkedListCycle/linkedListCycle.cpp
     * 使用两个节点，一个每次移一步，另外一个一次移两步，如果存在循环，那一定会相遇
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode p = head;
        ListNode q = head;

        while (p != null && q != null) {
            p = p.next;
            if (q.next == null)
                return false;
            q = q.next.next;

            if (p == q)
                return true;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;

        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();

        ListNode p = head;
        while (p != null) {
            if (map.get(p) != null)
                return true;

            map.put(p, p);
            p = p.next;
        }

        return false;
    }
}
