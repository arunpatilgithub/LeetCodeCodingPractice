public class TrappingRainWater42 {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));

    }

    private static int trap(int[] height) {

        final int N = height.length;
        int[] leftMax = new int[N];

        int maxLeftHeight = height[0];
        leftMax[0] = height[0];
        for (int i=1; i<N; i++) {

            if (height[i] > maxLeftHeight) {
                maxLeftHeight = height[i];
            }
            leftMax[i] = maxLeftHeight;

        }

        int[] rightMax = new int[N];
        int maxRightHeight = height[N-1];
        rightMax[N-1] = maxRightHeight;


        for (int j=N-2; j>=0; j--) {

            if (height[j] > maxRightHeight) {
                maxRightHeight = height[j];
            }
            rightMax[j] = maxRightHeight;

        }


        int waterCount = 0;

        for (int k=0;k<N; k++) {
            waterCount = waterCount + Math.min(leftMax[k], rightMax[k]) - height[k];
        }

        return waterCount;
    }

}
