import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowColumnPairs2352 {

    public static void main(String[] args) {

        System.out.println(equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));

    }

    private static int equalPairs(int[][] grid) {

        int count = 0;

        Map<String, Integer> rowMap = new HashMap<>();

        final int M = grid.length;
        final int N = grid[0].length;


        for (int i=0; i< M; i++) {
            StringBuilder row = new StringBuilder();
            for (int j=0; j< N; j++) {
                row.append(grid[i][j]+"-");
            }

            rowMap.put(row.toString(),rowMap.getOrDefault(row.toString(),0) +1);
        }

        for (int i=0; i< M; i++) {
            StringBuilder cols = new StringBuilder();
            for (int j=0; j< N; j++) {
                cols.append(grid[j][i] + "-");
            }

            count = count + rowMap.getOrDefault(cols.toString(),0);
        }

        return count;
    }

    private static int equalPairs2(int[][] grid) {

        int count = 0;

        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        final int M = grid.length;
        final int N = grid[0].length;


        for (int i=0; i< M; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j< N; j++) {
                row.add(grid[i][j]);
            }
            rowMap.put(row,rowMap.getOrDefault(row,0) +1);
        }

        for (int i=0; i< M; i++) {
            List<Integer> cols = new ArrayList<>();
            for (int j=0; j< N; j++) {
                cols.add(grid[j][i]);
            }

            count = count + rowMap.getOrDefault(cols,0);
        }

        return count;
    }

}
