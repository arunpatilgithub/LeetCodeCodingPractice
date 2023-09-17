import java.util.Arrays;

public class MoveZeroes283 {

    public static void main(String[] args) {

        moveZeroes(new int[]{0,1,1,3,12});
        //moveZeroes(new int[]{2,0,1,0,3,12});
        //moveZeroes(new int[]{0,0,0,0,12});
    }

    private static void moveZeroes(int[] nums) {

        int l=0;

        for (int r=0; r< nums.length; r++) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }

        Arrays.stream(nums).forEach(System.out::println);
    }

}
