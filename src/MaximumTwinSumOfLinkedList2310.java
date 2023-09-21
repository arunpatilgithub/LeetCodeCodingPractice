import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumTwinSumOfLinkedList2310 {

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(pairSum(head));
    }

    private static int pairSum(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode iterator = head;

        while (iterator != null) {
            list.add(iterator.val);
            iterator = iterator.next;
        }

        int l=0;
        int r=list.size()-1;
        int maxTwin = Integer.MIN_VALUE;

        while (l<r) {
            maxTwin = Math.max(maxTwin, list.get(l)+list.get(r));
            l++;
            r--;
        }

        return maxTwin;

    }

    private static int pairSum1(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        List<Integer> forwardList = new ArrayList<>();

        while (curr != null && curr.next != null) {
            forwardList.add(curr.val);
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        curr.next = prev;
        forwardList.add(curr.val);

        int l=0;
        int r=forwardList.size()-1;
        int maxTwin = Integer.MIN_VALUE;

        while (l<r) {
            maxTwin = Math.max(maxTwin, forwardList.get(l)+forwardList.get(r));
            l++;
            r--;
        }

        return maxTwin;
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
