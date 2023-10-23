import java.util.Arrays;

public class MergeSortedArray88 {

    public static void main(String[] args) {

        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        //merge(new int[]{1}, 1, new int[]{}, 0);
        //merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {


        int insertPos = nums1.length-1;
        m = m-1;
        n = n-1;
        while (m >=0 && n >=0) {

            if (nums1[m] <= nums2[n]) {
                nums1[insertPos] = nums2[n];
                n--;
            } else {
                nums1[insertPos] = nums1[m];
                m--;
            }

            insertPos--;

        }


        while (n >=0) {
            nums1[insertPos] = nums2[n];
            n--;
            insertPos--;
        }

        Arrays.stream(nums1).forEach(System.out::println);

    }

}
