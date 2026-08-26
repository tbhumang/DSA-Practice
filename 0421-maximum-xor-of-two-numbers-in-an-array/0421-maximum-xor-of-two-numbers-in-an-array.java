class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }
    TrieNode root = new TrieNode();
    private void insert(int num) {
        TrieNode curr = root;
        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            if (curr.child[b] == null) {
                curr.child[b] = new TrieNode();
            }
            curr = curr.child[b];
        }
    }
    private int getMaxXor(int num) {
        TrieNode curr = root;
        int result = 0;
        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            int opposite = 1 - b;
            if (curr.child[opposite] != null) {
                result |= (1 << bit);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[b];
            }
        }
        return result;
    }
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(num));
        }
        return maxXor;
    }
}