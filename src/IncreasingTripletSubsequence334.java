public class IncreasingTripletSubsequence334 {

    public static void main(String[] args) {

        System.out.println(increasingTriplet(new int[]{1,5,0,4,1,3}));
//        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
//        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
//        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
//        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));

    }

    private static boolean increasingTriplet(int[] nums) {

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;


        for (int num : nums) {

            if (num <= firstSmallest) {
                firstSmallest = num;
            }

            else if (num <= secondSmallest) {
                secondSmallest = num;
            }

            else {
                return true;
            }
        }

        return false;
    }

}
