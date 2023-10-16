import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache146 {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);

        cache.get(1);
        cache.get(2);

    }

    static class LRUCache {

        int capacity;
        Map<Integer, DoubleEndedNode> cache;

        DoubleEndedNode head;
        DoubleEndedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();

            head = new DoubleEndedNode();
            head.name = "head";

            tail = new DoubleEndedNode();
            tail.name = "tail";

            head.prev = tail;
            tail.next = head;

        }

        public int get(int key) {

            if (cache.get(key) != null) {

                DoubleEndedNode cachedObj = cache.get(key);

                cachedObj.prev.next = cachedObj.next;
                cachedObj.next.prev = cachedObj.prev;

                //Move to head
                cachedObj.prev = head.prev;
                cachedObj.next = head;
                head.prev.next = cachedObj;
                head.prev = cachedObj;

                System.out.println(cachedObj.val);
                return cachedObj.val;
            }

            System.out.println(-1);
            return -1;
        }


        public void put(int key, int value) {

            DoubleEndedNode cachedObj = cache.get(key);

            if (cachedObj == null) {
                cachedObj = new DoubleEndedNode(key, value);
                cache.put(key, cachedObj);

            } else {
                cachedObj.val = value;

                cachedObj.prev.next = cachedObj.next;
                cachedObj.next.prev = cachedObj.prev;

            }

            head.prev.next = cachedObj;
            cachedObj.prev = head.prev;
            cachedObj.next = head;
            head.prev = cachedObj;


            //evict
            if (cache.size() > capacity) {
                cache.remove(tail.next.key);
                tail.next = tail.next.next;
                tail.next.prev = tail;
            }

        }

        class DoubleEndedNode {

            int key;
            int val;

            String name;

            DoubleEndedNode prev;
            DoubleEndedNode next;

            public DoubleEndedNode() {
            }

            public DoubleEndedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public DoubleEndedNode getPrev() {
                return prev;
            }

            public void setPrev(DoubleEndedNode prev) {
                this.prev = prev;
            }

            public DoubleEndedNode getNext() {
                return next;
            }

            public void setNext(DoubleEndedNode next) {
                this.next = next;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

}
