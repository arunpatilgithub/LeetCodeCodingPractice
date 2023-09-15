public class RemoveDuplicatesSortedArray26 {

    public static void main(String[] args) {

        int[]nums = {0,0,1,1,1,2,2,3,3,4};

        //System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates(new int[]{1,1,1,1,2}));
        //System.out.println(removeDuplicates(new int[]{1}));
    }

    private static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }


        int uniqueCount = 1;
        int k = 1;

        for (int i =1; i<nums.length; i++) {

            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
                uniqueCount++;
            }

        }

        return uniqueCount;

    }

}
