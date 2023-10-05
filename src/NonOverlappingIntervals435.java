import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {

    public static void main(String[] args) {

        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][] {{1,2},{2,3}}));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {

        int removeOperationCount = 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int lastIntervalEndTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {

            if (interval[0] < lastIntervalEndTime) {
                removeOperationCount++;
                lastIntervalEndTime = Math.min(lastIntervalEndTime, interval[1]);
            } else {
                lastIntervalEndTime = interval[1];
            }

        }

//        PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length,
//                Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1])
//        );
//
//        for (int[] interval : intervals) {
//            heap.offer(interval);
//        }
//
//        int lastIntervalEndTime = Integer.MIN_VALUE;
//        while (!heap.isEmpty()) {
//
//            int[] curr = heap.poll();
//            if (curr[0] < lastIntervalEndTime) {
//                removeOperationCount++;
//                lastIntervalEndTime = Math.min(lastIntervalEndTime, curr[1]);
//            } else {
//                lastIntervalEndTime = curr[1];
//            }
//        }

        return removeOperationCount;
    }

}
