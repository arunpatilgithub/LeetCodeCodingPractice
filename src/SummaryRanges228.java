import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

    public static void main(String[] args) {

        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    private static List<String> summaryRanges(int[] nums) {

        List<String> output = new ArrayList<>();

        int l=0;
        int r=0;

        while (r < nums.length) {

            while (r < nums.length -1 && nums[r+1] ==  nums[r]+1) {
                r++;
            }
            output.add(l == r ? String.valueOf(nums[l]) : nums[l] +"->" + nums[r]);
            l = r+1;
            r = l;
        }

        return output;
    }

}
