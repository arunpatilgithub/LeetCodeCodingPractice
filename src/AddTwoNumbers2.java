import util.LinkedListCreator;
import util.LinkedListCreator.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AddTwoNumbers2 {

    public static void main(String[] args) {

        ListNode output = addTwoNumbers(LinkedListCreator.createLinkedList(new int[]{9,9,9,9,9,9,9}),
                LinkedListCreator.createLinkedList(new int[]{9,9,9,9}));

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Queue<Integer> l1Queue = new LinkedList<>();
        Queue<Integer> l2Queue = new LinkedList<>();

        while (l1 != null) {
            l1Queue.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Queue.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        Queue<Integer> outputQueue = new LinkedList<>();

        while (!l1Queue.isEmpty() && !l2Queue.isEmpty()) {

            int sum =  carry + l1Queue.poll() + l2Queue.poll();
            carry = sum / 10;
            outputQueue.add(sum%10);
        }

        while (!l1Queue.isEmpty()) {
            int sum =  carry + l1Queue.poll();
            carry = sum / 10;
            outputQueue.add(sum%10);
        }

        while (!l2Queue.isEmpty()) {
            int sum =  carry + l2Queue.poll();
            carry = sum / 10;
            outputQueue.add(sum%10);
        }

        if (carry != 0) {
            outputQueue.add(carry);
        }

        ListNode output = null;
        ListNode prevNode = null;
        while (!outputQueue.isEmpty()) {
            if (output == null) {
                output = new ListNode(outputQueue.poll());
                prevNode = output;
            } else {
                ListNode newNode = new ListNode(outputQueue.poll());
                prevNode.next = newNode;
                prevNode = newNode;
            }
        }

        return output;

    }



}
