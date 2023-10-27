import java.util.*;

public class Combinations77 {

    public static void main(String[] args) {

        combine(4,2).stream().forEach(System.out::println);
        combine(1,1).stream().forEach(System.out::println);
    }

    private static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(n,k, 1, result, new ArrayList<>());
        return result;
    }

    private static void backtrack(int n, int k, int currIndex, List<List<Integer>> result, List<Integer> currentList) {

        if (currentList.size() == k) {

            result.add(new ArrayList<>(currentList));

            return;
        }


        for (int i=currIndex; i<=n; i++) {
                currentList.add(i);
                backtrack(n,k,i+1, result, currentList);
                currentList.remove(currentList.size()-1);
        }

    }

}
