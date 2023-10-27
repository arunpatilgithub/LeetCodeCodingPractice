import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    public static void main(String[] args) {

        combinationSum(new int[]{2,3,6,7}, 7).stream().forEach(System.out::println);

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> output = new ArrayList<>();

        backtrack(candidates, target, output, new ArrayList<>(), 0);

        return output;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> output, List<Integer> currentList, int currIndex) {

        if (target == 0) {
            output.add(new ArrayList<>(currentList));
            return;
        }

        if (target<0) {
            return;
        }

        for (int i=currIndex; i<candidates.length; i++) {

            currentList.add(candidates[i]);
            backtrack(candidates, target-candidates[i], output, currentList,i);
            currentList.remove(currentList.size()-1);

        }


    }

}
