import java.util.Arrays;
import java.util.Collections;

public class RotateArray189 {

    public static void main(String[] args) {

        rotate(new int[]{1,2,3,4,5,6,7},3);
        rotateOptimal(new int[]{1,2,3,4,5,6,7},3);

    }

    private static void rotate(int[] nums, int k) {

        /*
        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]

        length = 7
        0 = 3
        1 = 4
        2 = 5
        3 = 6
        4 = 0
        5 = 1
        6 = 2

        */

        for (int l=0; l< nums.length; l++) {
            System.out.printf(nums[l] + "-");
        }
        System.out.println("");

        if (k==0) return;
        if (nums == null || nums.length == 0) return;

        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            res[newIndex] = nums[i];
        }

        //assign back to original array
        for (int i=0; i<nums.length; i++) {
            nums[i] = res[i];
        }

        for (int j=0; j< nums.length; j++) {
            System.out.printf(nums[j] + "-");
        }

    }

    private static void rotateOptimal(int[] nums, int k) {

        //In case k is greater than or equal to array length.
        k = k % nums.length;

        //Step 1: reverse entire array.
        reverse(nums, 0, nums.length-1);

        //Step 2: reverse first k element after step 1.
        reverse(nums, 0, k-1);

        //Step 3: reverse remaining elements after k.
        reverse(nums, k, nums.length-1);

        System.out.println("");
        for (int j=0; j< nums.length; j++) {
            System.out.printf(nums[j] + "*");
        }
    }

    private static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

}
