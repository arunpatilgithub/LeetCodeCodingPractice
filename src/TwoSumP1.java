import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumP1 {

    public static void main(String[] args) {

        Arrays.stream(twoSum(new int[]{15,2,11,7}, 9)).forEach(System.out::println);
        Arrays.stream(twoSum(new int[]{3,2,4}, 6)).forEach(System.out::println);
    }

    private static int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i< nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                output[0] = i;
                output[1] = map.get(target-nums[i]);
                break;
            }
        }

        return output;
    }

}

