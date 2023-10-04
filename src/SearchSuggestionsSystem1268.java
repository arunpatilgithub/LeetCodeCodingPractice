import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem1268 {

    public static void main(String[] args) {

        List<List<String>> output = suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},
                                                      "mouse");
    }

    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        PriorityQueue<String> pq = new PriorityQueue<>(3, (s1,s2) -> s1.compareTo(s2));
        List<List<String>> list = new ArrayList<>();

        for(int i = 1; i<=searchWord.length(); i++){
            String temp = searchWord.substring(0, i);
            for(String s : products){
                if(s.startsWith(temp)){
                    pq.offer(s);
                }
            }
            List<String> temp_list = new ArrayList<>();
            for(int j = 0; j<3; j++){
                if(pq.peek() != null){
                    temp_list.add(pq.poll());
                }
            }
            pq.clear();
            list.add(temp_list);
        }
        return list;

    }
    private static List<List<String>> suggestedProducts1(String[] products, String searchWord) {

        TrieNode root = new TrieNode();
        for (String product: products) {
            insert(root, product);
        }

        List<List<String>> results = new ArrayList<>();

        for (char c: searchWord.toCharArray()) {
            root = root.children[c - 'a'];
            if (root == null) {
                break;
            }
            results.add(root.getTopThree());
        }

        while (results.size() < searchWord.length()) {
            results.add(new ArrayList<>());
        }

        return results;

    }

    private static void insert(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null)
                root.children[c - 'a'] = new TrieNode();
            root = root.children[c - 'a'];
            root.addToPQ(word);
        }
    }

    static class TrieNode {
        public TrieNode[] children;
        public PriorityQueue<String> pq;

        public TrieNode() {
            children = new TrieNode[26];
            pq = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addToPQ(String word) {
            pq.add(word);
            if (pq.size() > 3) pq.poll();
        }

        public List<String> getTopThree() {
            List<String> topThree = new ArrayList<>();
            while (!pq.isEmpty()) topThree.add(pq.poll());
            Collections.reverse(topThree);
            return topThree;
        }
    }

}
