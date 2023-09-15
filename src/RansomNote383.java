import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    public static void main(String[] args) {

        System.out.println(canConstruct("aa","aab"));
        System.out.println(canConstruct("aa","ab"));
        System.out.println(canConstruct("a","b"));
    }

    private static boolean canConstructOptimal(String ransomNote, String magazine) {

        int[] charFrequency = new int[26];

        for (char c : magazine.toCharArray())
            charFrequency[c-'a'] = charFrequency[c-'a']+1;

        for (char c : ransomNote.toCharArray()){
            if (charFrequency[c-'a'] == 0) return false;
            charFrequency[c-'a'] = charFrequency[c-'a'] -1;
        }
        return true;

    }

    private static boolean canConstructWithMap(String ransomNote, String magazine) {

        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (charFrequency.containsKey(c) && charFrequency.get(c) > 0) {
                charFrequency.put(c, charFrequency.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;

    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        int[] magazineArray = new int[128];

        for (int j=0; j<magazine.length(); j++) {
            magazineArray[magazine.charAt(j)] = magazineArray[magazine.charAt(j)] + 1;
        }

        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int remainingChars = magazineArray[c];
            if (remainingChars <=0) {
                return false;
            }
            magazineArray[c] = magazineArray[c] -1;
        }

        return true;
    }


}
