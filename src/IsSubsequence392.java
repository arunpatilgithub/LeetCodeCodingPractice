public class IsSubsequence392 {

    public static void main(String[] args) {

        //System.out.println(isSubsequence("axc","ahbgdc"));
        System.out.println(isSubsequence("aaaaaa","bbaaaa"));
    }

    private static boolean isSubsequence(String s, String t) {

        int sCounter = 0;
        int tCounter = 0;

        while (sCounter < s.length() && tCounter < t.length()) {

            if (s.charAt(sCounter) == t.charAt(tCounter)) {
                sCounter++;
                tCounter++;
            } else {
                tCounter++;
            }

        }

        return sCounter == s.length() ? true : false;

    }

}
