import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords30 {

    public static void main(String[] args) {

        findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}).stream().forEach(System.out::println);
        //findSubstring("barfoothefoobarman", new String[]{"foo","bar"}).stream().forEach(System.out::println);
        //findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}).stream().forEach(System.out::println);
        //findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}).stream().forEach(System.out::println);
        //findSubstring("aaa", new String[]{"a","a"}).stream().forEach(System.out::println);
    }

    private static List<Integer> findSubstring(String s, String[] words) {

        int expectedWordCount = words.length;
        int eachWordLength = words[0].length();
        int subStringLength =  eachWordLength * expectedWordCount;


        Map<String, Integer> frequencyMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();

        for (String w : words) {
            frequencyMap.put(w, frequencyMap.getOrDefault(w,0)+1);
        }

        int l=0;

        while (l <= s.length()-subStringLength) {

            int wordsEncountered = 0;

            Map<String, Integer> seenMap = new HashMap<>();


            for (int j=l; j<l+subStringLength; j=j+eachWordLength) {

                String currentWord = s.substring(j,j+eachWordLength);
                if (seenMap.getOrDefault(currentWord,0) < frequencyMap.getOrDefault(currentWord,0)) {
                    seenMap.put(currentWord, seenMap.getOrDefault(currentWord,0)+1);
                    wordsEncountered++;
                }


            }


//            for (String w : words) {
//
//                if (s.substring(l,l+subStringLength).contains(w)
//                        && seenMap.getOrDefault(w,0) < frequencyMap.get(w)) {
//                    seenMap.put(w, seenMap.getOrDefault(w,0)+1);
//                    wordsEncountered++;
//                }
//
//            }
            if (wordsEncountered == expectedWordCount) {
                output.add(l);

            }
            l++;

        }

        return output;



    }

}
