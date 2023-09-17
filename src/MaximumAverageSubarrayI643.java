public class MaximumAverageSubarrayI643 {

    public static void main(String[] args) {

        System.out.println(findMaxAverage(new int[]{0,1,1,3,3},4));
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage(new int[]{5},1));
    }

    private static double findMaxAverage(int[] nums, int k) {

        if (nums.length < k) {
            return 0.0;
        }

        int l=0;
        int r=k;
        double sum=0;
        for (int i=0; i<k;i++) {
            sum = sum + nums[i];
        }

        double maxAverage = sum/k;

        while (r <= nums.length-1) {
            sum = sum-nums[l];
            sum = sum + nums[r];
            maxAverage = Math.max(maxAverage,sum/k);
            l++;
            r++;
        }

        return maxAverage;

    }

}
