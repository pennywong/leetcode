import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * <p/>
 * Created by Penny on 27/1/15.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);

        RandomListNode p = dummy;
        RandomListNode q = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (q != null) {
            RandomListNode node = new RandomListNode(q.label);
            p.next = node;
            p = node;

            map.put(q, node);
            q = q.next;
        }

        p = dummy.next;
        q = head;
        while (q != null) {
            if (q.random != null) {
                p.random = map.get(q.random);
            }
            p = p.next;
            q = q.next;
        }

        return dummy.next;
    }
}
