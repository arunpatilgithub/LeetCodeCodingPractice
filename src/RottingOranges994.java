import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

    public static void main(String[] args) {

        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
        System.out.println(orangesRotting(new int[][]{{0}}));
        System.out.println(orangesRotting(new int[][]{{1},{2},{2}}));

    }

    private static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }


        int[][] directions = {  {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        int minutes = 0;

        while (!queue.isEmpty()) {

            int qSize = queue.size();
            int rottenThisRound = 0;
            boolean[][] markedForQueue = new boolean[m][n];

            for (int q=0; q<qSize; q++) {
                int[] currentPos = queue.poll();

                for (int[] newDir : directions) {

                    int newRow = currentPos[0] + newDir[0];
                    int newCol = currentPos[1] + newDir[1];


                    if (newRow>=0 && newRow < m && newCol >=0 && newCol<n
                            && grid[newRow][newCol] == 1
                            && !markedForQueue[newRow][newCol]) {

                        markedForQueue[newRow][newCol] = true;
                        grid[newRow][newCol] = 2;
                        rottenThisRound++;
                        queue.add(new int[]{newRow, newCol});

                    }

                }

            }

            if (rottenThisRound > 0) {
                minutes++;
                freshOranges -= rottenThisRound;
            }
        }


        return freshOranges == 0 ? minutes : -1;
    }

}
