public class MaxConsecutiveOnesIII1004 {

    public static void main(String[] args) {

        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));

    }

    private static int longestOnes(int[] nums, int k) {

        int maxOnes=0;

        int l=0;
        int r=0;
        int zerosEncountered=0;

        while (r<nums.length) {

            if (nums[r] == 0) {
                zerosEncountered++;
            }

            while (zerosEncountered > k) {
                if (nums[l] == 0) {
                    zerosEncountered--;
                }
                l++;
            }

            maxOnes = Math.max(maxOnes, r - l + 1);

            r++;

        }

        return maxOnes;

    }

}
