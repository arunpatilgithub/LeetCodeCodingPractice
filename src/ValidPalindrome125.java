public class ValidPalindrome125 {

    public static void main(String[] args) {

        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("."));
    }

    private static boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() -1;

        while (l<=r) {

            while (l < s.length()-1 && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (r < 0) {
                return true;
            }

            if (l > r) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l ++;
            r --;

        }

        return true;
    }

}
