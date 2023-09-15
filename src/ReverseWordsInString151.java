public class ReverseWordsInString151 {

    public static void main(String[] args) {

        //System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));

    }

    private static String reverseWords(String s) {

        s = s.trim();

        String[] sArr = s.split(" ");

        String output = "";

        for (int i= sArr.length-1; i>=0; i--) {

            if (sArr[i] != "") {
                String temp = sArr[i].trim();
                output = output.concat(temp+" ");
            }

        }

        return output.trim();

    }

}
