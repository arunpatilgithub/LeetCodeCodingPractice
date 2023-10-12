import util.LinkedListCreator;
import util.LinkedListCreator.ListNode;

public class ReverseNodesInKGroup25 {

    public static void main(String[] args) {

        print(reverseKGroup(LinkedListCreator.createLinkedList(new int[]{1,2,3,4,5}), 1));
        print(reverseKGroup(LinkedListCreator.createLinkedList(new int[]{1,2,3,4,5}), 5));
        print(reverseKGroup(LinkedListCreator.createLinkedList(new int[]{1,2,3,4,5}), 3));
        print(reverseKGroup(LinkedListCreator.createLinkedList(new int[]{1,2,3,4,5}), 2));
        print(reverseKGroup(LinkedListCreator.createLinkedList(new int[]{1,2,3,4}), 2));
    }

    private static ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1) {
            return head;
        }

        int length = 0;

        ListNode traverser = head;

        while (traverser != null) {
            length++;
            traverser = traverser.next;
        }

        if (k > length) {
            return head;
        }

        int i=0;

        ListNode prev = null;
        traverser = head;

        ListNode preSetTail = head;

        while (i+k <= length) {

            int kIndex = 0;

            ListNode currTail = traverser;

            while (kIndex < k) {
                ListNode temp = traverser.next;
                traverser.next = prev;
                prev = traverser;
                traverser = temp;
                kIndex++;
                i++;
            }

            ListNode currHead = prev;

            if (i == k) {
                head = currHead;
                preSetTail = currTail;
            } else {
                preSetTail.next = currHead;
                preSetTail = currTail;

            }

            prev = null;

        }

        if (i<length) {
            preSetTail.next = traverser;
        }

        return head;

    }

    private static void print(ListNode node) {

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
