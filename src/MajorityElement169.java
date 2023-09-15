import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));

    }

    private static int majorityElement(int[] nums) {

        var map = new HashMap<Integer, Integer>();

        for(int i : nums) {
            map.compute(i, (key, value) -> value == null ? 1 : value + 1);
        }


        int maxCount = Integer.MIN_VALUE;
        int majorityElement = -1;

        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > maxCount) {
                maxCount = m.getValue();
                majorityElement = m.getKey();
            }
        }

        return majorityElement;
    }

}
