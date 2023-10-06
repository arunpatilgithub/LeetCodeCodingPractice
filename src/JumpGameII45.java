import java.util.Arrays;

public class JumpGameII45 {

    public static void main(String[] args) {

        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,1,4}));
        //System.out.println(jump(new int[]{2,3,0,1,4}));
    }

    private static int jump2(int[] nums) {

        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return recurse(nums,0, dp);
    }

    private static int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length-1) {

            for (int i=l; i<=r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;

        }


        return jumps;
    }


    private static int recurse(int[] nums, int index, int[] dp) {

        if (index == nums.length-1) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int jump = Integer.MAX_VALUE;
        for (int i = index+1; i<nums.length && i<= index+nums[index]; i++) {
            int internalJump = Integer.MAX_VALUE;

            internalJump = Math.min(internalJump, 1 + recurse(nums,i, dp));

            if (internalJump != Integer.MIN_VALUE) {
                jump = Math.min(jump, internalJump);
            }

        }

        dp[index] = jump;
        return jump;

    }


}
