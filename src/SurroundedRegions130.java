public class SurroundedRegions130 {

    public static void main(String[] args) {

        String[][] stringArray = {
                {"X","X","X","X"},
                {"X","O","O","X"},
                {"X","X","O","X"},
                {"X","O","X","X"}
        };

        String input = "cccccccc";
        //String input = "gbhgbhgbhgbh";

        solve(stringToCharArray(stringArray));
        solve(new char[][]{{'X'}});
        solve(new char[][]{{'O','O'},{'O','O'}});

    }

    private static void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'E';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);

    }

    private static char[][] stringToCharArray(String[][] stringArray) {

        char[][] charArray = new char[stringArray.length][stringArray[0].length];

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                charArray[i][j] = stringArray[i][j].charAt(0);
            }
        }
        return charArray;
    }

}
