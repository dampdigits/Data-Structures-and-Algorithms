// Implementation of Trie data structure in java.

/*
Trie object will be instantiated and called as such:
Trie obj = new Trie();
obj.insert(word);
param_0 = obj.search(word);
param_1 = obj.startsWith(word);
*/

// Create Trie node
class TrieNode {
    public char val;
    public boolean isEnd;
    public TrieNode[] children;

    // Constructor
    public TrieNode(char val) {
        this.val = val;
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    // Create root node
    public Trie() {
        root = new TrieNode(' ');
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(c);
            }
            node = node.children[index];
        }
        node.isEnd = true;  // Mark the end of a word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return node.isEnd;
    }

    // Check if a word in Trie starts with prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return true;
    }
}
