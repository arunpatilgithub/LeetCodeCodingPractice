import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {


        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));

    }

    private static int lengthOfLongestSubstring(String s) {

        int[] charPos = new int[128];

        Arrays.fill(charPos, -1);
        int maxLength=0, currLength=0;
        int l=0,r = 0;

        while (r <= s.length()-1) {

            char rc = s.charAt(r);

            if (charPos[rc] == -1 || charPos[rc] < l) {
                charPos[rc] = r;
                //maxLength = Math.max(maxLength, (r-l) + 1);
                currLength = r-l+1;
                r++;
            } else {
                l = charPos[rc] +1;
                maxLength = Math.max(maxLength,currLength);
                currLength = 0;
            }

        }

        return Math.max(maxLength,currLength);
    }

}
