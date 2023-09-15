import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix54 {

    public static void main(String[] args) {

        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(
                spiralOrder(input).stream()
                        .map(Object::toString)
                        .reduce((s1, s2) -> s1 + ", " + s2)
                        .orElse("")
        );
    }

    private static List<Integer> spiralOrder(int[][] matrix) {

        String currentDirection = "E";
        List<Integer> result = new ArrayList<>();
        final int M = matrix.length;
        final int N = matrix[0].length;

        int row=0;
        int col=0;
        int visitedNums = 0;

        boolean[][] visited = new boolean[M][N];

        while (visitedNums < M*N) {

            if (currentDirection == "E") {

               if (isRowColWithinRange(row, col, M, N) && !visited[row][col]) {
                   visited[row][col] = true;
                   result.add(matrix[row][col]);
                   visitedNums++;
                   col++;
               } else {
                   currentDirection = "S";
                   col--;
                   row++;
               }

            } else if (currentDirection == "S") {

                if (isRowColWithinRange(row, col, M, N) && !visited[row][col]) {
                    visited[row][col] = true;
                    result.add(matrix[row][col]);
                    visitedNums++;
                    row++;
                } else {
                    currentDirection = "W";
                    col--;
                    row--;
                }

            } else if (currentDirection == "W") {

                if (isRowColWithinRange(row, col, M, N) && !visited[row][col]) {
                    visited[row][col] = true;
                    result.add(matrix[row][col]);
                    visitedNums++;
                    col--;
                } else {
                    currentDirection = "N";
                    row--;
                    col++;
                }

            } else {

                if (isRowColWithinRange(row, col, M, N) && !visited[row][col]) {
                    visited[row][col] = true;
                    result.add(matrix[row][col]);
                    visitedNums++;
                    row--;
                } else {
                    currentDirection = "E";
                    row++;
                    col++;
                }

            }
        }


        return result;
    }

    private static boolean isRowColWithinRange(int currRow, int currCol, int maxRowLength, int maxColLength) {

        if (currRow>=0 && currRow < maxRowLength && currCol >=0 && currCol <maxColLength) {
            return true;
        }

        return false;

    }

}
