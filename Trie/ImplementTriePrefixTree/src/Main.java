class Trie {
    private static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(final String word) {
        TrieNode pCrawl = root;

        for (final char ch : word.toCharArray()) {
            final int idx = ch - 'a';

            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }

            pCrawl = pCrawl.children[idx];
        }

        pCrawl.isEnd = true;
    }

    public boolean search(final String word) {
        TrieNode pCrawl = root;

        for (final char ch : word.toCharArray()) {
            final int idx = ch - 'a';

            if (pCrawl.children[idx] == null) {
                return false;
            }

            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.isEnd;
    }

    public boolean startsWith(final String prefix) {
        TrieNode pCrawl = root;

        for (final char ch : prefix.toCharArray()) {
            final int idx = ch - 'a';

            if (pCrawl.children[idx] == null) {
                return false;
            }

            pCrawl = pCrawl.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("mango");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("mango"));
    }
}