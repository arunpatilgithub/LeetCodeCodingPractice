public class EditDistance72 {

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }

    private static int minDistance(String word1, String word2) {

        int N = word1.length()+1;
        int M = word2.length()+1;

        int[][] dp = new int[M][N];

        for (int i=0; i<M; i++) {
            dp[i][N-1] = M-1-i;
        }

        for (int j=0; j<N; j++) {
            dp[M-1][j] = N-1-j;
        }

        for (int row = word2.length()-1; row>=0; row--) {
            for (int col = word1.length()-1; col>=0; col--) {

                if (word2.charAt(row) == word1.charAt(col)) {
                    dp[row][col] = dp[row+1][col+1];
                } else {
                    dp[row][col] = 1 + Math.min(dp[row+1][col+1], Math.min(dp[row+1][col], dp[row][col+1]));
                }

            }
        }

        return dp[0][0];
        //Commenting below recursion call.
        //return recurse(word1, word2, 0, 0);
    }

    private static int recurse(String word1, String word2, int index1, int index2) {

        if (index1 >= word1.length() && index2 >= word2.length()) {
            return 0;
        }

        if (index1 >= word1.length()) {
            return word2.length()-index2;
        }

        if (index2 >= word2.length()) {
            return word1.length()-index1;
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return recurse(word1, word2, index1+1, index2 + 1);
        }

        int replace = recurse(word1, word2, index1+1, index2 + 1);
        int add = recurse(word1, word2, index1, index2 + 1);
        int delete = recurse(word1, word2, index1+1, index2);


        return 1 + Math.min(replace, Math.min(add, delete));
    }

}
