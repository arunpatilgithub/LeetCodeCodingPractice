public class LongestSubarrayOnesAfterDeletingOneElement1493 {

    public static void main(String[] args) {

        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(longestSubarray(new int[]{1,1,1}));
    }

    private static int longestSubarray(int[] nums) {

        int maxOnes=0;
        int k=1;

        int l=0; int r=0;

        int zerosEncountered = 0;


        while (r< nums.length) {

            if (nums[r] == 0) {
                zerosEncountered++;
            }

            while (zerosEncountered>k) {
                if (nums[l] == 0) {
                    zerosEncountered--;
                }
                l++;
            }

            maxOnes = Math.max(maxOnes, r-l+1);
            r++;

        }


        return maxOnes-1;

    }

}
