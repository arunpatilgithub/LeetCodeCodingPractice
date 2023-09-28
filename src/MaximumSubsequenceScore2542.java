import java.util.*;

public class MaximumSubsequenceScore2542 {

    public static void main(String[] args) {

        System.out.println(maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
        System.out.println(maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
    }

//    private static long maxScore(int[] nums1, int[] nums2, int k) {
//        int n = nums1.length;
//        long maxScore = 0;
//
//        List<Pair> pairs = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            pairs.add(new Pair(nums1[i], nums2[i]));
//        }
//        pairs.sort(Comparator.comparing(Pair::getElement1).thenComparing(Comparator.comparing(Pair::getElement0).reversed()));
//
//        lo sum = 0
//
//
//        return maxScore;
//    }

    private static long maxScore(int[] nums1, int[] nums2, int k) {


        long maxScore;
        int arrayLength = nums1.length;



        List<Pair> pairs = new ArrayList<>();

        for (int i=0; i<arrayLength; i++) {
            pairs.add(new Pair(nums1[i], nums2[i]));
        }

        pairs.sort(Comparator.comparing(Pair::getElement1).reversed());

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long n1Sum = 0;

        for (int i=0; i<k; i++) {
            int currNumVal = pairs.get(i).element0;
            heap.add(currNumVal);
            n1Sum = n1Sum + currNumVal;
        }
        maxScore = n1Sum * pairs.get(k-1).element1;

        for (int j=k; j< pairs.size(); j++) {

            //There is no need to push an element in the heap if the current element is smaller.
            // Because we are moving in the descending order of nums2, and our heap already have 3 max possible numbers.
            // If we reduce the sum of elements in the heap,
            // we will minimize the output as we will then multiply it will smaller number.
            if (heap.peek() < pairs.get(j).element0) {
                int removedNUmberFromN1 = heap.poll();
                heap.add(pairs.get(j).element0);

                n1Sum = n1Sum + pairs.get(j).element0 - removedNUmberFromN1;

                maxScore = Math.max(maxScore, n1Sum * pairs.get(j).element1);
            }

        }



        return maxScore;

    }

    static class Pair {

        private final Integer element0;
        private final Integer element1;

        public Pair(Integer element0, Integer element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public Integer getElement0() {
            return element0;
        }

        public Integer getElement1() {
            return element1;
        }
    }



}
