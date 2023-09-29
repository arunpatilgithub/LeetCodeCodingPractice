import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers2462 {

    public static void main(String[] args) {

        System.out.println(totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3,4));
        System.out.println(totalCost(new int[]{1,2,4,1}, 3,3));

    }

    private static long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getCost).thenComparing(Pair::getIndexPos));

        int i=0;

        while (i<costs.length && i <candidates) {
            minHeap.add(new Pair(costs[i],i));
            i++;
        }

        int leftRightIndex = minHeap.size() - 1;

        //Now right side.
        int j=costs.length-1;

        while (j > leftRightIndex && j >= costs.length - candidates) {
            minHeap.add(new Pair(costs[j], j));
            j--;
        }

        int rightLeftIndex = ++j;


        long totalCost = 0;

        for (int l =0; l<k; l++) {

            Pair hiredCandidate = minHeap.poll();
            totalCost = totalCost + hiredCandidate.cost;


            int candidateIndexPos = hiredCandidate.indexPos;

            if (candidateIndexPos<=leftRightIndex) {
                if (leftRightIndex < rightLeftIndex-1) {
                    leftRightIndex++;
                    minHeap.add(new Pair(costs[leftRightIndex],leftRightIndex));
                }
            } else if (candidateIndexPos >= rightLeftIndex) {
                if (rightLeftIndex > leftRightIndex + 1) {
                    rightLeftIndex--;
                    minHeap.add(new Pair(costs[rightLeftIndex],rightLeftIndex));
                }
            }

        }


        return totalCost;
    }

    static class Pair {

        private int cost;
        private int indexPos;

        public Pair(int value, int indexPos) {
            this.cost = value;
            this.indexPos = indexPos;
        }

        public int getCost() {
            return cost;
        }

        public int getIndexPos() {
            return indexPos;
        }
    }

}
