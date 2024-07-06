public class LC80 {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,3,3};
        //int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int partition = 2;

        for (int i=2; i< nums.length; i++) {

            if (nums[i] != nums[i-2]) {
                nums[partition] = nums[i];
                partition=partition + 2;
            }
        }

        return partition;
    }

}
