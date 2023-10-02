import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {

    public static void main(String[] args) {

        //combinationSum3(3,7).forEach(System.out::println);
        combinationSum3(3,9).forEach(System.out::println);

    }

    private static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(),k,n,1);
        
        return combinations;
    }


    private static void backtrack(List<List<Integer>> combinations, List<Integer> currentList, int k, int n, int i) {

        if (n == 0 && currentList.size() == k) {
            combinations.add(new ArrayList<>(currentList));
        }

        if (n <0 || currentList.size() >= k) {
            return;
        }

        for (int j = i; j<=9; j++) {
            currentList.add(j);
            backtrack(combinations, currentList, k, n-j, j+1);
            currentList.remove(currentList.size()-1);
        }

    }

}
