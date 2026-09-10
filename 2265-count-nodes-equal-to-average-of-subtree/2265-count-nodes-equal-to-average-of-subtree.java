class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode n) {
        if (n == null) return new int[]{0, 0};

        int[] l = dfs(n.left), r = dfs(n.right);
        int sum = n.val + l[0] + r[0];
        int cnt = 1 + l[1] + r[1];

        if (sum / cnt == n.val) ans++;
        return new int[]{sum, cnt};
    }
}
