import java.util.Arrays;

public class HouseRobber198 {

    public static void main(String[] args) {

        System.out.println(rob(new int[]{2,7,9,3,1}));
//        System.out.println(rob(new int[]{1,2,3,1}));
//        System.out.println(rob(new int[]{1,2}));
//        System.out.println(rob(new int[]{1,3,1}));
        System.out.println(rob(new int[]{1,2,1,1}));
    }

    private static int rob(int[] nums) {

        int[] cache = new int[nums.length];

        Arrays.fill(cache, -1);

        return rec(nums, 0, cache);
    }

    private static int rec (int[] nums, int index, int[] cache) {


        if (index >= nums.length) {
            return 0;
        }

        if (cache[index] != -1) {
            return cache[index];
        }

        int oneHop = nums[index] + rec(nums, index+2, cache);

        int twoHop = rec(nums, index+1, cache);

        cache[index] = Math.max(oneHop, twoHop);

        return cache[index];

    }


}
