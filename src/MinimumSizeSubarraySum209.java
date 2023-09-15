public class MinimumSizeSubarraySum209 {

    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    private static int minSubArrayLen(int target, int[] nums) {

        int l=0;
        int r=0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (r<nums.length) {
            sum = sum + nums[r];
            r++;

            while (sum >= target) {
                result = Math.min(result, (r-l));
                sum = sum - nums[l];
                l++;
            }
        }

        if (r == nums.length-1 && l < r) {
            while (l < r) {

            }
        }


        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
