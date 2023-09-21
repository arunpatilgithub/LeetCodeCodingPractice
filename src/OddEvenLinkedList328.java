import java.util.List;

public class OddEvenLinkedList328 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,
                                     new ListNode(2,
                                                  new ListNode(3,
                                                               new ListNode(4, new
                                                                       ListNode(5,
                                                                                new ListNode(6,
                                                                                             new ListNode(7)))))));

        head = oddEvenList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }

    private static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastOdd = head;
        ListNode firstEven = head.next;
        ListNode lastEven = head.next;

        ListNode traverser = head.next.next;
        boolean oddIndex = true;

        lastEven.next = null;

        while (traverser != null) {

            ListNode nextNode = traverser.next;
            traverser.next = null;

            if (oddIndex) {
                lastOdd.next = traverser;
                lastOdd = traverser;
            } else {
                lastEven.next = traverser;
                lastEven = traverser;
            }

            traverser = nextNode;;
            oddIndex = !oddIndex;
        }

        lastOdd.next = firstEven;

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
