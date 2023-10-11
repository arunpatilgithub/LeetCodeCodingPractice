import util.LinkedListCreator;
import util.LinkedListCreator.ListNode;

public class AddTwoNumbers2 {

    public static void main(String[] args) {

        ListNode output = addTwoNumbers(LinkedListCreator.createLinkedList(new int[]{2,4,3}),
                LinkedListCreator.createLinkedList(new int[]{5,6,4}));

        while (output != null) {
            System.out.println(output.getVal());
        }

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {



    }



}
