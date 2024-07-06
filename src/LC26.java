public class LC26 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {

        int partition = 1;

        for (int i=1; i< nums.length; i++) {

            if (nums[i] != nums[i-1]) {
                nums[partition] = nums[i];
                partition++;
            }
        }

        return partition;
    }

}
