public class RemoveDuplicatesFromSortedArrayIIP {

    public static void main(String[] args) {

        //System.out.println(removeDuplicates(new int[]{1,1,2,2,2,3}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        //System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));

    }

    private static int removeDuplicates(int[] nums) {

        if (nums.length < 3) {
            return nums.length;
        }

        int partition = 2;

        for (int i=2; i< nums.length; i++) {

            if (nums[i] != nums[partition-2]) {
                nums[partition] = nums[i];
                partition++;
            }
        }

        return partition;

    }

}
