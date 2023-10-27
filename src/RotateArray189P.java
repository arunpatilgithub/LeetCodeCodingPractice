import java.util.Arrays;

public class RotateArray189P {

    public static void main(String[] args) {

        rotate(new int[]{1,2,3,4,5,6,7}, 3);
        //rotate(new int[]{-1,-100,3,99}, 2);
    }

    private static void rotate(int[] nums, int k) {

        /*int[] tempArr = new int[nums.length];
        int len = nums.length;

        k = k % nums.length;

        for (int i=0; i< len; i++) {
            int newIndex = (i+k) % len;
            tempArr[newIndex] = nums[i];
        }

        for (int j=0; j<len; j++) {
            nums[j] = tempArr[j];
        }*/


        //rotate whole array;

        k = k % nums.length;


        rotateArrayElements(nums, 0, nums.length-1);
        rotateArrayElements(nums, 0, k-1);
        rotateArrayElements(nums, k, nums.length-1);

        Arrays.stream(nums).forEach(System.out::println);

    }

    private static void rotateArrayElements(int[] nums, int start, int end) {
        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;

        }
    }

}