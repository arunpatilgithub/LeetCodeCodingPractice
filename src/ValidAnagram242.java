public class ValidAnagram242 {

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sourceCharsCount = new int[26];

        for (char sourceC : s.toCharArray()) {
            sourceCharsCount[sourceC-'a'] = sourceCharsCount[sourceC-'a']+1;
        }

        for (char targetC : t.toCharArray()) {
            if (sourceCharsCount[targetC-'a'] <=0) {
                return false;
            } else {
                sourceCharsCount[targetC-'a'] = sourceCharsCount[targetC-'a']-1;
            }
        }

        return true;
    }

}
