import java.util.Arrays;

public class RemoveElement27 {

    public static void main(String[] args) {

        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
        private static int removeElement(int[] nums, int val) {

        int count=0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count ++;
            }
        }

        return count;
    }

}
