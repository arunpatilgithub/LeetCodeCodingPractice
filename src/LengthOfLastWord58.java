public class LengthOfLastWord58 {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    private static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length-1].length();

    }

}
