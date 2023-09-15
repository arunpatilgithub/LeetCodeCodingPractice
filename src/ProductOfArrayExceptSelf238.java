import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {

    public static void main(String[] args) {
        //print(productExceptSelf(new int[]{1,2,3,4}));
        print(productExceptSelf(new int[]{-1,1,0,-3,3}));
    }

    private static int[] productExceptSelf(int[] nums) {

        int arraySize = nums.length;

        int[] leftProduct = new int[arraySize];
        leftProduct[0] = 1;

        for (int i=1;i<arraySize;i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }



        int[] outputArray = new int[arraySize];

        int rightProduct = 1;
        outputArray[arraySize-1] = 1;
        for (int k=arraySize-1; k>=0; k--) {
            outputArray[k] = leftProduct[k] * rightProduct;
            rightProduct = rightProduct * nums[k];

        }

        return outputArray;


    }

    private static void print(int[] nums) {

        for (int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }

}
