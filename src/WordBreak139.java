import java.util.*;

public class WordBreak139 {

    public static void main(String[] args) {

        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        //System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        return backtrack(s, 0, dictionary, new Boolean[s.length()]);
    }

    private static boolean backtrack(String s, int pos, Set<String> dictionary, Boolean[] memoi) {

        if (pos == s.length()) {
            return true;
        }

        if (memoi[pos] != null) {
            return memoi[pos];
        }

        for (int i = pos; i<s.length(); i++) {
            String tempString = s.substring(pos,i+1);
            if (dictionary.contains(tempString) && backtrack(s,i+1,dictionary, memoi)) {
                memoi[pos] = true;
                return true;
            }
        }
        memoi[pos] = false;
        return false;
    }


}
