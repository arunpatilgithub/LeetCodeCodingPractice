import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ClimbingStairs77 {

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {

        Map<Integer, Integer> map = new HashMap();
        AtomicInteger counter = new AtomicInteger(0);
        return dfs(n,0, map);

    }

    private static int dfs(int n, int currentStep, Map<Integer, Integer> map) {

        if (currentStep == n-1) {
            return 1;
        }

        if (currentStep == n-2) {
            return 2;
        }

        if (map.get(currentStep) != null) {
            return map.get(currentStep);
        }

        int oneStep = dfs(n,currentStep+1, map);
        map.put(currentStep+1, oneStep);

        int twoStep = dfs(n, currentStep+2, map);

        map.put(currentStep+2, twoStep);
        return oneStep + twoStep;

    }

}
