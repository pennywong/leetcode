/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * <p/>
 * Created by Penny on 2014/12/01
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);

        if (lengthA == 0 || lengthB == 0)
            return null;

        if (lengthA < lengthB) {
            ListNode t = headA;
            headA = headB;
            headB = t;
        }

        for (int i = 0; i < Math.abs(lengthA - lengthB); i++)
            headA = headA.next;

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
