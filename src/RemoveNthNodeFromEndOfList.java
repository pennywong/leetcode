/**
 * Created by Penny on 12/11/14.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        int count = 1;
        ListNode start = head;

        ListNode node = head.next;
        while (node != null) {
            if (count > n)
                start = start.next;

            count++;
            node = node.next;
        }

        if (count == n)
            head = head.next;
        else
            start.next = start.next.next;

        return head;
    }
}
