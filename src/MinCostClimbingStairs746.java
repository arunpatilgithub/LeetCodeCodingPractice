import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs746 {

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    private static int minCostClimbingStairs(int[] cost) {

        int[] cache = new int[cost.length];

        return Math.min(recur(cost,0, cache), recur(cost,1, cache));

    }

    private static int recur(int[] cost, int i, int[] cache) {

        if (i == cost.length-1 || i == cost.length-2) {
            return cost[i];
        }

        if (cache[i] != 0) {
            return cache[i];
        }

        int nextStepCost = recur(cost, i+1, cache);
        cache[i+1] = nextStepCost;

        int nextToNextStepCost = recur(cost,i+2, cache);
        cache[i+2] =  nextToNextStepCost;

        return cost[i] + Math.min(nextStepCost,nextToNextStepCost);

    }

}
