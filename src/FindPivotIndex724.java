public class FindPivotIndex724 {

    public static void main(String[] args) {

        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
        System.out.println(pivotIndex(new int[]{1,2,3}));

    }

    private static int pivotIndex(int[] nums) {

        int totalSum = 0;

        for (int n : nums) {
            totalSum = totalSum + n;
        }

        int leftSum=0;

        for (int i=0;i<nums.length; i++) {

            totalSum = totalSum - nums[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum = leftSum + nums[i];


        }

        return -1;

    }

    private static int pivotIndex2(int[] nums) {

        int[] lSum = new int[nums.length];
        int[] rSum = new int[nums.length];

        int runningSum=0;
        for (int i=0;i<nums.length; i++) {

            if (i == 0) {
                lSum[i]=0;
            } else {
                runningSum = runningSum + nums[i-1];
                lSum[i] = runningSum;
            }

        }

        runningSum=0;

        for (int j=nums.length-1;j>=0;j--) {
            if (j == nums.length-1) {
                rSum[j]=0;
            } else {
                runningSum = runningSum + nums[j+1];
                rSum[j]=runningSum;
            }
        }

        for (int k=0; k<nums.length; k++) {
            if (lSum[k] == rSum[k]) {
                return k;
            }
        }

        return -1;

    }

}
