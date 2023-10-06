public class GameOfLife289 {

    public static void main(String[] args) {

        gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }

    private static void gameOfLife(int[][] board) {

        int[][] directions = new int[][]{
                                            {-1,0},
                                            {-1,1},
                                            {0,1},
                                            {1,1},
                                            {1,0},
                                            {1,-1},
                                            {0,-1},
                                            {-1,-1}
                                        };



        int M = board.length;
        int N = board[0].length;
        int zeroButMarkedFor1 = 9;
        int oneButMarkedForZero = -1;
        for (int i=0; i<M; i++) {

            for (int j=0; j<N; j++) {

                int currState = board[i][j];

                int oneCount = 0;
                int zeroCount = 0;

                for(int[] dir : directions) {

                    int newRow = i+dir[0];
                    int newCol = j + dir[1];

                    if (newRow <0 || newRow >=M || newCol <0 || newCol >= N ) {
                        zeroCount++;
                    } else {
                        if (board[newRow][newCol] == 0 ||  board[newRow][newCol] == zeroButMarkedFor1) {
                            zeroCount ++;
                        } else {
                            oneCount++;
                        }
                    }

                }

                if (currState == 0 ) {
                    if (oneCount == 3) {
                        board[i][j] = zeroButMarkedFor1;
                    }
                } else {
                    if (oneCount<2 || oneCount > 3) {
                        board[i][j] = oneButMarkedForZero;
                    }
                }

            }
        }

        for (int i=0; i<M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == oneButMarkedForZero) {
                    board[i][j] = 0;
                } else if (board[i][j] == zeroButMarkedFor1) {
                    board[i][j] = 1;
                }
            }
        }

    }

}
