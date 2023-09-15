import java.util.*;

public class ThreeSum15 {

    public static void main(String[] args) {
        print(threeSum(new int[]{-1,0,1,2,-1,-4}));
        print(threeSum(new int[]{0,1,1}));
        print(threeSum(new int[]{0,0,0}));
        print(threeSum(new int[]{0,0,0,0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<Integer> uniqueNums = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i< nums.length-2; i++) {

            if (uniqueNums.contains(nums[i])) {
                continue;
            }
            uniqueNums.add(nums[i]);
            result.addAll(twoSum(nums, i+1, nums[i]));

        }

        return result;

    }

    private static List<List<Integer>> twoSum(int[] nums, int l,int target) {

        target = target * -1;
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> uniqueNums = new HashSet<>();
        int r = nums.length-1;

        while (l<r) {
            if (!uniqueNums.contains(nums[l])) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    uniqueNums.add(nums[l]);
                    result.add(List.of(target * -1, nums[l], nums[r]));
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            } else {
                l++;
            }
        }

        return result;
    }


    private static void print(List<List<Integer>> result) {
        result.stream().forEach(System.out::println);

        System.out.println("----------------------");
    }

}
