import java.util.HashMap;
import java.util.Map;

/**
 * Incomplete - Need to fix this.
 */
public class MinimumWindowSubstring76 {

    public static void main(String[] args) {

//        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd","abcdd"));
//        System.out.println(minWindow("xabcde","abc"));
//        System.out.println(minWindow("ab","b"));
//        System.out.println(minWindow("a","aa"));
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    private static String minWindow(String s, String t) {

        String output = "";
        int minOutputLength = Integer.MAX_VALUE;

        Map<Character, Integer> expectedOccurrence = new HashMap<>();
        Map<Character, Integer> actualOccurrence = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            expectedOccurrence.put(t.charAt(i), expectedOccurrence.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int wordCountSoFar = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);

            if (expectedOccurrence.containsKey(rc)) {
                actualOccurrence.put(rc, actualOccurrence.getOrDefault(rc, 0) + 1);
                if (actualOccurrence.get(rc) <= expectedOccurrence.get(rc)) {
                    wordCountSoFar++;
                }
            }

            while (wordCountSoFar == t.length()) {
                int currentLength = r - l + 1;
                if (currentLength < minOutputLength) {
                    minOutputLength = currentLength;
                    output = s.substring(l, r + 1);
                }

                char lc = s.charAt(l);
                if (expectedOccurrence.containsKey(lc)) {
                    actualOccurrence.put(lc, actualOccurrence.get(lc) - 1);
                    if (actualOccurrence.get(lc) < expectedOccurrence.get(lc)) {
                        wordCountSoFar--;
                    }
                }

                l++;
            }
        }

        return output;

    }




}
