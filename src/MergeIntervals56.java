import java.util.*;

public class MergeIntervals56 {

    public static void main(String[] args) {

        //printMatrix(merge(new int[][]{{1,4},{2,3}}));
        printMatrix(merge(new int[][]{{2,6},{1,3},{8,10},{15,18}}));
        //printMatrix(merge(new int[][]{{1,4},{4,5}}));
    }

    private static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        for (int i=0; i<intervals.length; i++) {

            if (list.isEmpty()) {
                list.add(intervals[i]);

            } else {
                int[] temp = list.get(list.size()-1);
                if (intervals[i][0] <= temp[1]) {
                    temp[0] = Math.min(intervals[i][0],temp[0]);
                    temp[1] = Math.max(temp[1],intervals[i][1]);

                } else {
                    list.add(intervals[i]);
                }
            }

        }

        return list.toArray(new int[list.size()][]);
    }

    private static void printMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Determine the maximum width of any element in the matrix
        int maxElementWidth = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                int elementWidth = String.valueOf(element).length();
                maxElementWidth = Math.max(maxElementWidth, elementWidth);
            }
        }

        // Print the matrix with equal spacing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                System.out.printf("%" + (maxElementWidth + 1) + "d", element);
            }
            System.out.println(); // Move to the next row
        }

    }

}
