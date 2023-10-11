package util;

public class LinkedListCreator {

    public static ListNode createLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            current.next = newNode;
            current = current.next;
        }

        return dummy.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode() {}
        public ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}

