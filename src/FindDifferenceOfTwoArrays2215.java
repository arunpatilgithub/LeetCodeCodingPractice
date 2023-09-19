import java.util.*;

public class FindDifferenceOfTwoArrays2215 {

    public static void main(String[] args) {
        printList(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        printList(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> output = new ArrayList<>();

        Set<Integer> nums1Set = new HashSet<>();

        Arrays.stream(nums1).forEach(n -> nums1Set.add(n));

        Set<Integer> nums2Set = new HashSet<>();
        Arrays.stream(nums2).forEach(n -> nums2Set.add(n));


        Set<Integer> nums1Diff = new HashSet<>(nums1Set);
        nums1Diff.removeAll(nums2Set);

        Set<Integer> nums2Diff = new HashSet<>(nums2Set);
        nums2Diff.removeAll(nums1Set);

        output.add(new ArrayList<>(nums1Diff));
        output.add(new ArrayList<>(nums2Diff));

        return output;

    }

    private static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {

        List<List<Integer>> output = new ArrayList<>();

        Set<Integer> nums1Set = new HashSet<>();

        Arrays.stream(nums1).forEach(n -> nums1Set.add(n));

        Set<Integer> nums2Set = new HashSet<>();
        Arrays.stream(nums2).forEach(n -> nums2Set.add(n));

        List<Integer> distinct = new ArrayList<>();
        output.add(distinct);
        for (int n: nums1) {
            if (!nums2Set.contains(n) && !distinct.contains(n)) {
                distinct.add(n);
            }
        }

        distinct = new ArrayList<>();
        output.add(distinct);
        for (int n: nums2) {
            if (!nums1Set.contains(n) && !distinct.contains(n)) {
                distinct.add(n);
            }
        }

        return output;
    }


    private static void printList(List<List<Integer>> list) {
        list.stream().forEach(System.out::println);
    }

}
