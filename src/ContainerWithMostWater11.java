public class ContainerWithMostWater11 {

    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1,8,100,2,100,4,8,3,7}));
        //System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private static int maxArea(int[] height) {

        int l = 0;
        int r = height.length -1;

        int maxWater = 0;

        while (l<r) {
            maxWater = Math.max((r-l)*Math.min(height[l],height[r]),maxWater);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxWater;
    }

}
