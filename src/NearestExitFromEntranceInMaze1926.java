import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze1926 {

    public static void main(String[] args) {

//        System.out.println(nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}},
//                new int[]{1,2}));

//        System.out.println(nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},{'+','+','+'}},
//                new int[]{1,0}));

        System.out.println(nearestExit(new char[][]{{'.','+'}},
               new int[]{0,0}));

    }

    private static int nearestExit(char[][] maze, int[] entrance) {

        int output = 0;

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        int[][] directions = {  {-1, 0},
                                {1, 0},
                                {0, -1},
                                {0, 1}
                            };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);

        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if ((curr[0] == 0 || curr[0] == maze.length - 1 || curr[1] == 0 || curr[1] == maze[0].length - 1) &&
                        !(curr[0] == entrance[0] && curr[1] == entrance[1])) {
                    return output;
                }

                for (int[] direction : directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];

                    if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
                            && maze[newRow][newCol] == '.'
                            && !visited[newRow][newCol]) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }

            }

            output++;

        }

        return -1;

    }




}
