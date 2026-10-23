class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    String dfs(TreeNode node) {
        if (node == null) return "#";
        String s = node.val + "," + dfs(node.left) + "," + dfs(node.right);
        if (map.getOrDefault(s, 0) == 1) ans.add(node);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}