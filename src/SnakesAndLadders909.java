import java.util.*;

public class SnakesAndLadders909 {

    public static void main(String[] args) {

        System.out.println(snakesAndLadders(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
        System.out.println(snakesAndLadders(new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}}));

    }

    private static int snakesAndLadders(int[][] board) {

        int N = board.length;
        int lastCell = N * N;

        boolean[] visited = new boolean[lastCell];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int height = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            height++;

            for (int i=0; i<size; i++) {

                int currPos = queue.poll();

                for (int roll = currPos+1; roll<=Math.min(6+currPos, lastCell); roll++) {

                    if (roll == lastCell) {
                        return height;
                    }

                    if (!visited[roll]) {

                        visited[roll] = true;

                        int[] newPos = posToRowCol(roll,N);


                        int boardNewPos = board[newPos[0]][newPos[1]];

                        if (boardNewPos == lastCell) {
                            return height;
                        }

                        if (boardNewPos != -1) {
                            queue.add(boardNewPos);
                        } else {
                            queue.add(roll);
                        }
                    }

                }

            }

        }

        return -1;
    }

    private static int[] posToRowCol(int position, int n) {

        int row = (position - 1) / n;
        int col = (position - 1) % n;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        row = n - 1 - row;

        return new int[] {row, col};

    }

}
