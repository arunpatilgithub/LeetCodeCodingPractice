public class IndexOfFirstOccurrenceInString28 {

    public static void main(String[] args) {

        System.out.println(strStr("aaaaa","bba"));
        System.out.println(strStr("sadbutsad","sad"));
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("a","a"));

    }

    private static int strStr(String haystack, String needle) {

        for (int i=0; i<=haystack.length()-needle.length(); i++) {
            int k = 0;

            if (haystack.charAt(i) == needle.charAt(0)) {
                while (k < needle.length()-1 && haystack.charAt(i+k) == needle.charAt(k)) {
                    k++;
                }
            }

            if (k == needle.length()-1 && haystack.charAt(i+k) == needle.charAt(k)) {
                return i;
            }
        }

        return -1;
    }

}
