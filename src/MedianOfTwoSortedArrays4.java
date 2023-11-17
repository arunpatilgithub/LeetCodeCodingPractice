public class MedianOfTwoSortedArrays4 {

    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //Make sure nums1 is always the smallest array.
        if (nums2.length < nums1.length) {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m; //nums1 length
        int halfArrayLength = (m+n+1) / 2;

        // binary search on small array
        while (l <= r) {
            int smallArrayPartitionPoint = (l+r) / 2;
            int largeArrayPartitionPoint = halfArrayLength - smallArrayPartitionPoint;

            int maxLeftOfSmallArray = smallArrayPartitionPoint == 0 ? Integer.MIN_VALUE : nums1[smallArrayPartitionPoint-1];
            int minRightOfSmallArray = smallArrayPartitionPoint == m ? Integer.MAX_VALUE :  nums1[smallArrayPartitionPoint];

            int maxLeftOfLargeArray = largeArrayPartitionPoint == 0 ? Integer.MIN_VALUE : nums2[largeArrayPartitionPoint-1];
            int minRightOfLargeArray = largeArrayPartitionPoint == n ? Integer.MAX_VALUE :  nums2[largeArrayPartitionPoint];

            if (maxLeftOfSmallArray<=minRightOfLargeArray && maxLeftOfLargeArray <= minRightOfSmallArray) {

                if ((m+n) % 2 == 0) {//Even elements in combined array.
                    return (Math.max(maxLeftOfLargeArray, maxLeftOfSmallArray) + Math.min(minRightOfLargeArray, minRightOfSmallArray)) / 2.0;
                } else {
                    return Math.max(maxLeftOfLargeArray, maxLeftOfSmallArray);
                }
            } else if (maxLeftOfSmallArray > minRightOfLargeArray) {
                r = smallArrayPartitionPoint-1;//left side of the mid of small array.
            } else {
                l = smallArrayPartitionPoint+1;
            }

        }

        return 0.0;

    }

}
