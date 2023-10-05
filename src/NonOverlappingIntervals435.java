import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NonOverlappingIntervals435 {

    public static void main(String[] args) {

        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {

        int removeOperationCount = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1])
        );

        for (int[] interval : intervals) {
            heap.offer(interval);
        }

        int lastIntervalEndTime = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {

            int[] curr = heap.poll();
            if (curr[0] < lastIntervalEndTime) {
                removeOperationCount++;
                lastIntervalEndTime = Math.min(lastIntervalEndTime, curr[1]);
            } else {
                lastIntervalEndTime = curr[1];
            }
        }

        return removeOperationCount;
    }

}
