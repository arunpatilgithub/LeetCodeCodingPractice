import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

    public static void main(String[] args) {

        System.out.println(hasCycle(createLinkedListWithCycle(new int[]{3,2,0,-4},1)));

    }


    private static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {

            if (slow == fast) {
                return true;
            }

            if (slow.next == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;

        }

        return false;

    }

    private static boolean hasCycle2(ListNode head) {

        Set<ListNode> visited = new HashSet<>();

        while (head != null) {

            if (visited.contains(head)) {
                return true;
            }

            visited.add(head);
            head = head.next;

        }

        return false;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode createLinkedListWithCycle(int[] nums, int pos) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode cycleStart = null;

        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            current.next = newNode;
            current = current.next;

            if (i == pos) {
                cycleStart = current;
            }
        }

        if (cycleStart != null) {
            current.next = cycleStart;
        }

        return dummy.next;
    }



}
