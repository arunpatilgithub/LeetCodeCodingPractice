import java.util.HashMap;

public class ContainsDuplicateII219 {

    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1},1));

    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> positionMap = new HashMap<>();

        for (int i=0; i< nums.length; i++) {

            if (positionMap.containsKey(nums[i])) {
                if (i - positionMap.get(nums[i]) <= k) {
                    return true;
                }
            }

            positionMap.put(nums[i], i);

        }

        return false;
    }

}
