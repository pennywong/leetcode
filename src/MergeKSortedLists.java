import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * <p/>
 * Created by Penny on 2015/01/16
 */
public class MergeKSortedLists {
    /**
     * 参考：http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val)
                    return 1;
                else if (o1.val < o2.val)
                    return -1;
                else
                    return 0;
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                priorityQueue.add(node);
        }


        ListNode head = new ListNode(0);
        ListNode p = head;
        while (priorityQueue.size() > 0) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null)
                priorityQueue.add(node.next);
            p = p.next;
        }

        return head.next;
    }
}
