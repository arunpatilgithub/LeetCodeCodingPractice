public class ImplementTrie208 {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");

        System.out.println(trie.search("lapple"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("apd"));

    }



    static class Trie {

        static class Node {

            char val;
            Node[] children;
            boolean isWord;

            public Node() {
                children = new Node[26];
            }

        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {

            Node traverserNode = root;

            for (char c : word.toCharArray()) {
                if (traverserNode.children[c-'a'] == null) {
                    Node newChildNode = new Node();
                    newChildNode.val = c;
                    traverserNode.children[c-'a'] = newChildNode;
                }

                traverserNode = traverserNode.children[c-'a'];
            }
            traverserNode.isWord = true;
        }

        public boolean search(String word) {

            Node traverser = root;

            for (char c : word.toCharArray()) {

                if (traverser.children[c-'a'] == null) {
                    return false;
                }
                traverser = traverser.children[c-'a'];

            }

            return traverser.isWord;
        }

        public boolean startsWith(String prefix) {

            Node traverser = root;

            for (char c : prefix.toCharArray()) {

                if (traverser.children[c-'a'] == null) {
                    return false;
                }
                traverser = traverser.children[c-'a'];

            }

            return true;

        }


    }

}
