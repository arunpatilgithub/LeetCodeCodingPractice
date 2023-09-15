import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {

    public static void main(String[] args) {

        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));

    }


    private static boolean isValidSudoku(char[][] board) {


        for (int i=0; i<board.length; i++) {

            Set<Character> rowElements = new HashSet<>();
            Set<Character> coElements = new HashSet<>();
            Set<Character> boxElements = new HashSet<>();

            for (int j=0; j<board[i].length; j++) {

                //rows check
                if (board[i][j] != '.' && !rowElements.add(board[i][j])) {
                    return false;
                }

                //columns check
                if (board[j][i] != '.' && !coElements.add(board[j][i])) {
                    return false;
                }

                //3X3 Box check
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !boxElements.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;

            }
        }


        return true;
    }

}
