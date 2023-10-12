import util.LinkedListCreator;
import util.LinkedListCreator.ListNode;

public class ReverseLinkedListII92 {

    public static void main(String[] args) {

        ListNode output = reverseBetween(LinkedListCreator.createLinkedList(new int[]{1,2,3,4,5}), 2,4);
        //ListNode output = reverseBetween(LinkedListCreator.createLinkedList(new int[]{3,5}), 1,2);

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }

    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {

        // Check for no-op cases
        if (head == null || left == right) {
            return head;
        }

        // Introduce a dummy node to handle the case when the reversal starts from the head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        // Move the prevNode to the node just before the start of the segment to be reversed
        int position = 1;
        while (position != left) {
            prevNode = prevNode.next;
            position++;
        }

        // tailNode initially points to the first node to be reversed
        ListNode tailNode = prevNode.next;
        ListNode reversedPart = null;

        // Reverse the segment from position left to right
        while (position <= right) {
            ListNode nextNode = tailNode.next; // Save the next node
            tailNode.next = reversedPart;       // Reverse the link
            reversedPart = tailNode;            // Move the reversedPart forward
            tailNode = nextNode;                // Move the tailNode forward
            position++;
        }

        // Connect the reversed segment back to the list
        prevNode.next.next = tailNode;  // Connect the original end of the reversed segment to the remaining list
        prevNode.next = reversedPart;   // Connect the reversed segment to the list

        return dummy.next; // Return the head of the modified list
    }


}
