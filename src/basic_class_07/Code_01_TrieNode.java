package basic_class_07;

public class Code_01_TrieNode {
    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] next;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.next = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode node = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                TrieNode node = root;
                int index = 0;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.next[index].path == 0) {
                        node.next[index] = null;
                        return;
                    }
                    node = node.next[index];
                }
                node.end--;
            }


        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            TrieNode node = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.path;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }
}
