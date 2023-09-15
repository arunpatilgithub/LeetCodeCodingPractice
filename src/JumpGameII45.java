public class JumpGameII45 {

    public static void main(String[] args) {

        //System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

    private static int jump(int[] nums) {
        return backTrack(nums, 0);
    }

    private static int backTrack(int[] nums, int startIndex) {

        if (startIndex >= nums.length-1) {
            return 0;
        }

        int minPath = Integer.MAX_VALUE;

        for (int k=startIndex+1;k<=startIndex+nums[startIndex];k++) {
            int tempJump = Math.min(minPath,1+backTrack(nums, k));

            if (tempJump != Integer.MAX_VALUE) {
                minPath = Math.min(minPath, tempJump + 1);
            }
        }

        return minPath;

    }


}
