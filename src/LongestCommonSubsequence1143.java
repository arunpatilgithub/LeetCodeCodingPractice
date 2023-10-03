import java.util.Arrays;

public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {

        //System.out.println(longestCommonSubsequence("bl","yby"));
        System.out.println(longestCommonSubsequence("abcde","ace"));
        System.out.println(longestCommonSubsequence2("abcde","ace"));
    }

    private static int longestCommonSubsequence(String text1, String text2) {

        int M = text1.length() + 1;
        int N = text2.length() + 1;

        int[][] dp = new int[M][N];

        for (int i=M-1; i>=0; i--) {
            for (int j=N-1; j>=0; j--) {

                if (i == M-1 || j == N-1) {
                    dp[i][j] = 0;
                } else {

                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1 + dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                    }

                }

            }
        }

        return dp[0][0];

    }

    private static int longestCommonSubsequence2(String text1, String text2) {

        int[][] cache = new int[text1.length()][text2.length()];

        for(int i = 0; i < text1.length(); i++) {
            Arrays.fill(cache[i], -1);
        }

        return recursion(text1, text2, 0, 0, cache);
    }

    private static int recursion(String text1, String text2, int t1Index, int t2Index, int[][] cache) {

        if (t1Index >= text1.length() || t2Index >= text2.length()) {
            return 0;
        }

        if (cache[t1Index][t2Index] != -1) {
            return cache[t1Index][t2Index];
        }

        if (text1.charAt(t1Index) == text2.charAt(t2Index)) {
            return 1 + recursion(text1, text2, t1Index+1, t2Index+1, cache);
        } else {
            int output = Math.max(recursion(text1, text2, t1Index+1, t2Index, cache),
                                  recursion(text1, text2, t1Index, t2Index+1, cache));

            cache[t1Index][t2Index] = output;

            return output;
        }

    }
}
