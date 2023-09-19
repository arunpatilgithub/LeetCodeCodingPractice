import java.util.*;
import java.util.stream.Collectors;

public class DetermineIfTwoStringsAreClose1657 {

    public static void main(String[] args) {

        System.out.println(closeStrings("cabbba","abbccc"));
        System.out.println(closeStrings("cabbba","abbccc"));
        System.out.println(closeStrings("aaabbbbccddeeeeefffff","aaaaabbcccdddeeeeffff"));
    }


    private static boolean closeStrings(String word1, String word2) {

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        Map<Character, Integer> w1CountMap = new HashMap<>();
        Map<Character, Integer> w2CountMap = new HashMap<>();

        Set<Character> w1Set = new HashSet<>();
        for (char c : w1) {
            w1Set.add(c);
            w1CountMap.put(c, w1CountMap.getOrDefault(c,0)+1);
        }

        Set<Character> w2Set = new HashSet<>();

        for (char c: w2) {
            w2Set.add(c);
            w2CountMap.put(c, w2CountMap.getOrDefault(c,0)+1);
        }


        Set<Character> w1Unique = new HashSet<>(w1Set);
        Set<Character> w2Unique = new HashSet<>(w2Set);

        w1Unique.removeAll(w2Set);
        w2Unique.removeAll(w1Set);

        if (!w1Unique.isEmpty() && !w2Unique.isEmpty()) {
            return false;
        }

        List<Integer> w1Frequencies = w1CountMap.values().stream().sorted().toList();
        List<Integer> w2Frequencies = w2CountMap.values().stream().sorted().toList();


        return w1Frequencies.equals(w2Frequencies);
    }

}
