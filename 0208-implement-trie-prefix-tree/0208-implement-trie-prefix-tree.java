class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    public boolean search(String word) {
     TrieNode curr = root;
     for(char ch : word.toCharArray()){
        int index = ch - 'a';
        if(curr.children[index] == null){
            return false;
        }
        curr = curr.children[index];
     }   
     return curr.isEnd;
    }
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';

            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
