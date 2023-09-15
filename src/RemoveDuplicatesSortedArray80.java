public class RemoveDuplicatesSortedArray80 {

    public static void main(String[] args) {

        //System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{1,1,2,2,3}));
    }

    private static int removeDuplicates(int[] nums) {

        if (nums.length<3) {
            return nums.length;
        }

        int k = 2;
        for (int i=2; i<nums.length; i++) {

            if (nums[i] != nums[k-2]) {
                nums[k] = nums[i];
                k++;
            }

        }

        return k;

    }

}
