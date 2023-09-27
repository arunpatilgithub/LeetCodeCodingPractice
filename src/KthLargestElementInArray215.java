import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray215 {

    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest(new int[]{3,2,1},2));
    }

    private static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i: nums) {
            minHeap.add(i);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    private static int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i=0; i<nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }

        return minHeap.peek();
    }

}
