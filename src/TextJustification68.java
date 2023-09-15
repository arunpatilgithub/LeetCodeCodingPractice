import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextJustification68 {

    public static void main(String[] args) {

        //print(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
        print(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));

    }

    private static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> output = new ArrayList<>();
        Map<Integer, Integer> rowToRemainingSpaceMap = new HashMap<>();
        Map<Integer, Integer> rowToWordsCountMap = new HashMap<>();
        int rowNum = 0;

        int widthRemaining = maxWidth;
        String concat = "";

        int wordsRemaining = words.length;

        for (int i=0; i<words.length; i++) {
            int rowWordsCount=0;
            while (wordsRemaining > 0 && words[i].length() <= widthRemaining -1) {

                if (concat.equals("")) {
                    concat = words[i];
                    rowWordsCount++;
                } else {
                    concat = concat + " " + words[i] ;
                    rowWordsCount++;
                    widthRemaining =  widthRemaining -1;
                }
                wordsRemaining--;

                widthRemaining = widthRemaining - words[i].length();
                i++;
            }

            output.add(concat);

            rowToRemainingSpaceMap.put(rowNum,widthRemaining);
            rowToWordsCountMap.put(rowNum,rowWordsCount);

            if (i < words.length) {
                concat = "";
                i--;
                rowNum++;
                widthRemaining = maxWidth;
            }


        }

        return output;
    }
    private static void print(List<String> output) {
        output.forEach(System.out::println);
    }

}
