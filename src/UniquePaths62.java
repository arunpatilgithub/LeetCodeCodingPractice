public class UniquePaths62 {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3,7));
    }

    private static int uniquePaths(int m, int n) {

        int[][] cache = new int[m][n];

        for (int i = m-1 ; i>=0; i-- ) {
            for (int j=n-1; j>=0; j--) {

                if (i == m-1 || j == n-1) {
                    cache[i][j] = 1;
                } else {
                    cache[i][j] = cache[i+1][j] + cache[i][j+1];
                }

            }
        }


        return cache[0][0];

    }


}
