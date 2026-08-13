class Solution {

    static class Node {
        char leftChar;
        char rightChar;

        int length;
        int prefix;
        int suffix;
        int max;

        Node(char ch) {
            this.leftChar = ch;
            this.rightChar = ch;
            this.length = 1;
            this.prefix = 1;
            this.suffix = 1;
            this.max = 1;
        }

        Node() {}
    }

    Node[] tree;
    char[] s;

    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node();

        res.length = a.length + b.length;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        // Initially, maximum is from either side
        res.max = Math.max(a.max, b.max);

        res.prefix = a.prefix;
        res.suffix = b.suffix;

        // We can combine suffix of left
        // with prefix of right
        if (a.rightChar == b.leftChar) {

            res.max = Math.max(
                res.max,
                a.suffix + b.prefix
            );

            // Entire left segment has same character
            if (a.prefix == a.length) {
                res.prefix = a.length + b.prefix;
            }

            // Entire right segment has same character
            if (b.suffix == b.length) {
                res.suffix = a.suffix + b.length;
            }
        }

        return res;
    }

    private void update(int node, int l, int r,
                        int index, char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
            String str,
            String queryCharacters,
            int[] queryIndices) {

        int n = str.length();
        int k = queryIndices.length;

        s = str.toCharArray();

        tree = new Node[4 * n];

        // Build segment tree
        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Perform query update
            s[index] = ch;

            update(1, 0, n - 1, index, ch);

            // Root contains answer for entire string
            ans[i] = tree[1].max;
        }

        return ans;
    }
}