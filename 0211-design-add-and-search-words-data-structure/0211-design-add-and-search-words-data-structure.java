class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null &&
                    dfs(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, index + 1, node.children[ch - 'a']);
        }
    }
}