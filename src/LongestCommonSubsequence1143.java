import java.util.Arrays;

public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {

        //System.out.println(longestCommonSubsequence("bl","yby"));
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

    private static int longestCommonSubsequence(String text1, String text2) {

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
