import java.util.*;

public class UniqueNumberOfOccurrences1207 {

    public static void main(String[] args) {

        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));

    }

    private static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int a: arr) {
            countMap.put(a,countMap.getOrDefault(a,0)+1);
        }

        Set<Integer> uniques = new HashSet<>();

        for (int i : countMap.values()) {
            if (!uniques.add(i)) {
                return false;
            }
        }

        return true;
    }

}
