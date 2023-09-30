public class FindPeakElement162 {

    public static void main(String[] args) {

        //System.out.println(findPeakElement(new int[]{1,2,3,4}));
        //System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        //System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{1,2}));
    }

    private static int findPeakElement(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[length-1] > nums[length - 2]) {
            return length - 1;
        }

        int l = 1;
        int r = length - 2;

        while (l<=r) {

            int mid = l + (r-l) / 2;

            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }

}
