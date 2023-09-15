public class MergeStringsAlternately1768 {

    public static void main(String[] args) {

        System.out.println(mergeAlternately("ab","pqrs"));
        System.out.println(mergeAlternately("abc","pqr"));
    }

    private static String mergeAlternately(String word1, String word2) {

        int l = 0;
        int r = 0;
        int c = 0;
        char[] output = new char[word1.length()+word2.length()];

        while (l < word1.length() && r < word2.length()) {
            output[c] = word1.charAt(l);
            c++;
            output[c] = word2.charAt(r);
            c++;
            l++;
            r++;
        }

        while (l < word1.length()) {
            output[c] = word1.charAt(l);
            c++;
            l++;
        }

        while (r < word2.length()) {
            output[c] = word2.charAt(r);
            c++;
            r++;
        }

        return String.valueOf(output);
    }

}
