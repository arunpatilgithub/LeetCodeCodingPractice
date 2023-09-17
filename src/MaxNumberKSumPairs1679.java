import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberKSumPairs1679 {

    public static void main(String[] args) {

        System.out.println(maxOperations2(new int[]{3,1,3,4,3},6));
        System.out.println(maxOperations2(new int[]{1,2,3,4},5));
    }

    private static int maxOperations2(int[] nums, int k) {

        int operationCount = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int n: nums) {
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }

        for (int m : nums) {

            int comp = k-m;

            if (m == comp) {
                if (countMap.getOrDefault(m, 0) > 1) {
                    operationCount++;
                    countMap.put(m, countMap.get(m) - 2);
                }
            } else {
                if (countMap.getOrDefault(comp, 0) > 0 && countMap.getOrDefault(m, 0) > 0) {
                    operationCount++;
                    countMap.put(comp, countMap.get(comp) - 1);
                    countMap.put(m, countMap.get(m) - 1);
                }
            }

        }

        return operationCount;

    }

    private static int maxOperations(int[] nums, int k) {

        int operationCount = 0;

        Arrays.sort(nums);

        int l=0;
        int r= nums.length-1;

        while (l<r && l<nums.length && r>=0) {

            if (nums[l] + nums[r] == k) {
                operationCount++;
                l++;
                r--;
            } else if (nums[l]+nums[r] < k) {
                l++;
            } else {
                r--;
            }

        }

        return operationCount;

    }

}
