import java.util.Arrays;

public class LongestCommonPrefix14 {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }

    private static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        int counter = 0;

        while (counter <= strs[0].length() - 1 && strs[0].charAt(counter) == strs[strs.length-1].charAt(counter)) {
            counter++;
        }

        return counter > 0 ? strs[0].substring(0,counter) : "";

    }

}
