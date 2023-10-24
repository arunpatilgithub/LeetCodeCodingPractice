public class RemoveDuplicatesFromSortedArray26P {

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }

    private static int removeDuplicates(int[] nums) {

        int partition = 1;

        for (int i=1; i<nums.length; i++) {

            if (nums[i] != nums[i-1]) {
                nums[partition] = nums[i];
                partition++;
            }

        }

        return partition;

    }

}
