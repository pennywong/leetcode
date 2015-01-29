import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/lru-cache/
 * <p/>
 * Created by Penny on 2015/01/29
 */
public class LRUCache {
    /**
     * 参考：https://oj.leetcode.com/discuss/23427/sharing-clean-fast-java-solution-doubly-linkedlist-map-378ms
     */
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        removeNode(node);
        insertHead(node);

        return node.value;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            insertHead(node);
            return;
        }

        if (size == capacity) {
            node = tail.pre;
            removeNode(node);
            map.remove(node.key);
            size--;
        }

        node = new Node(key, value);
        insertHead(node);
        map.put(key, node);
        size++;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void insertHead(Node node) {
        node.next = head.next;
        head.next = node;
        node.pre = head;
        node.next.pre = node;
    }

    private class Node {
        private Integer key;
        private Integer value;
        private Node pre;
        private Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
