import java.util.HashMap;
import java.util.Map;

/**
 * Created by Penny on 2014/12/02
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();

        ListNode p = head;
        while (p != null) {
            if (map.get(p) != null)
                return p;

            map.put(p, p);
            p = p.next;
        }

        return null;
    }
}
