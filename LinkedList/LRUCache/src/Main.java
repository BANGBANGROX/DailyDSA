import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private static class ListNode {
        int key;
        int val;
        ListNode left;
        ListNode right;

        public ListNode(final int key, final int val) {
            this.key = key;
            this.val = val;
            this.left = this.right = null;
        }
    }

    private final Map<Integer, ListNode> keyToListNodeMap;
    private final int capacity;
    private final ListNode head;
    private final ListNode tail;

    public LRUCache(int capacity) {
        keyToListNodeMap = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.right = tail;
        tail.left = head;
        this.capacity = capacity;
    }

    public int get(final int key) {
        if (!keyToListNodeMap.containsKey(key)) {
            return -1;
        }

        final int val = keyToListNodeMap.get(key).val;

        deleteNode(key);
        addNode(key, val);

        return val;
    }

    public void put(final int key, final int value) {
        if (keyToListNodeMap.size() < capacity || keyToListNodeMap.containsKey(key)) {
            deleteNode(key);
            addNode(key, value);
            return;
        }

        final ListNode nodeToBeRemoved = tail.left;

        deleteNode(nodeToBeRemoved.key);
        addNode(key, value);
    }

    private void deleteNode(final int key) {
        final ListNode listNode = keyToListNodeMap.get(key);

        if (listNode == null) {
            return;
        }

        listNode.left.right = listNode.right;
        listNode.right.left = listNode.left;
        keyToListNodeMap.remove(key);
    }

    private void addNode(final int key, final int val) {
        final ListNode listNode = new ListNode(key, val);

        listNode.right = head.right;
        head.right.left = listNode;
        head.right = listNode;
        listNode.left = head;
        keyToListNodeMap.put(key, listNode);
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final LRUCache lruCache = new LRUCache(1);

        lruCache.put(1, 1);

        System.out.println(lruCache.get(1));

        lruCache.put(2, 2);

        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}