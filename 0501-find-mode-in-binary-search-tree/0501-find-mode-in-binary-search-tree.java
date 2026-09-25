class Solution {
    List<Integer> ans = new ArrayList<>();
    int max = 0, count = 0;
    Integer prev = null;

    public int[] findMode(TreeNode root) {
        dfs(root);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);

        if (prev != null && prev == root.val) count++;
        else count = 1;
        prev = root.val;

        if (count > max) {
            max = count;
            ans.clear();
            ans.add(root.val);
        } else if (count == max) ans.add(root.val);

        dfs(root.right);
    }
}
