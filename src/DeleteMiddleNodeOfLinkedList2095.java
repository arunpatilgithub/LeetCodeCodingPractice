public class DeleteMiddleNodeOfLinkedList2095 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1,
                                                                                                     new ListNode(2,
                                                                                                      new ListNode(6)            ))))));
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        //ListNode head = new ListNode(1);
        //ListNode head = new ListNode(2, new ListNode(1));

        ListNode output = deleteMiddle(head);

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }

    }

    private static ListNode deleteMiddle1(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now just before the middle node
        slow.next = slow.next.next;

        return dummy.next;

    }

    private static ListNode deleteMiddle(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode tempNode = head;

        while (fastPointer != null && fastPointer.next != null) {
            tempNode = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (head == slowPointer) {
            return null;
        }
        tempNode.next = slowPointer.next;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

    }

}
