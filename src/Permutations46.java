import java.util.ArrayList;
import java.util.List;

//Nice explanation here -> https://www.youtube.com/watch?v=H232aocj7bQ&ab_channel=NikhilLohia
public class Permutations46 {

    public static void main(String[] args) {

        permute(new int[]{1,2,3}).stream().forEach(System.out::println);
        permute(new int[]{1}).stream().forEach(System.out::println);
        permute(new int[]{1,2}).stream().forEach(System.out::println);
    }

    private static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums);

        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums) {

        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int num : nums) {

            if (!currentList.contains(num)) {
                currentList.add(num);
                backtrack(result, currentList, nums);
                currentList.remove(currentList.size()-1);
            }

        }

    }

}
