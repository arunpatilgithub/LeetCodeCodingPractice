import java.util.*;

public class ThreeSum15P {

    public static void main(String[] args) {

        threeSum(new int[]{-1, 0, 1, 2, -1, -4}).stream().forEach(System.out::println);
        threeSum(new int[]{-2,0,0,2,2}).stream().forEach(System.out::println);
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);

                int l = i + 1;
                int r = nums.length - 1;
                Set<Integer> internalVisited = new HashSet<>();

                while (l < r) {
                    int threeSum = nums[i] + nums[l] + nums[r];
                    if (threeSum == 0 && !internalVisited.contains(nums[l]) && !internalVisited.contains(nums[r])) {
                        internalVisited.add(nums[l]);
                        internalVisited.add(nums[r]);

                        output.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (threeSum < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }

            }
        }
        return output;
    }

}
