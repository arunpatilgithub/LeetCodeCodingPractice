public class GCDivisorOfStrings1071 {

    public static void main(String[] args) {

        //System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
    }

    private static String gcdOfStrings(String str1, String str2) {

        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                // Step 2: Check each divisor
                String candidate = str1.substring(0, i);
                if (checkDivisor(str1, candidate) && checkDivisor(str2, candidate)) {
                    return candidate;
                }
            }
        }
        return "";

    }

    private static boolean checkDivisor(String str, String candidate) {
        int len = str.length() / candidate.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(candidate);
        }
        return sb.toString().equals(str);
    }

}
