public class DominoAndTrominoTiling790 {

    public static void main(String[] args) {

        System.out.println(numTilings(3));

    }
//Need to fully understand it yet. This is not my code but also it's difficult to understand.
    private static int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        int mod = 1000000007;
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for(int i =4;i<=n;i++){
            dp[i]=(2*dp[i-1]%mod+dp[i-3]%mod)%mod;
        }

        return dp[n];
    }


}
