import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams49 {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = groupAnagrams(strs);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());

    }

    private static List<List<String>> groupAnagrams1(String[] strs) {

        if (strs.length == 0) {
            return Collections.emptyList();
        }
        String[] tempStrs = new String[strs.length];

        int i=0;
        Map<String, List<Integer>> grouping = new HashMap<>();

        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            tempStrs[i] = String.valueOf(temp);

            List<Integer> l = grouping.getOrDefault(tempStrs[i],new ArrayList<>());
            l.add(i);
            grouping.put(tempStrs[i],l);


            i++;
        }

        List<List<String>> output = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : grouping.entrySet()) {
            List temp = new ArrayList();
            List<Integer> indexes = entry.getValue();
            for (Integer x : indexes) {
                temp.add(strs[x]);
            }
            output.add(temp);
        }



        return output;
    }

    private static void print(List<List<String>> list) {

        list.stream().forEach(System.out::println);

    }


}
