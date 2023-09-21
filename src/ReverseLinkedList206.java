public class ReverseLinkedList206 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode output = reverseList(head);

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    private static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.next != null) {

            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

        }

        current.next = prev;
        head = current;

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
