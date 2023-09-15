public class JumpGame55 {

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{0,1}));
    }

    private static boolean canJump(int[] nums) {

        int validReachablePos = nums.length-1;

        for (int i= nums.length-1; i>=0;i--) {

            if (validReachablePos <=i + nums[i]) {
                validReachablePos = i;
            }

        }

        return validReachablePos == 0;

    }

}
