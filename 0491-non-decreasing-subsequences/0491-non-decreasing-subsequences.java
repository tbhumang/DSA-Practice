class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    void dfs(int[] a, int i, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() > 1) ans.add(new ArrayList<>(cur));
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < a.length; j++) {
            if (set.add(a[j]) && (cur.isEmpty() || a[j] >= cur.get(cur.size() - 1))) {
                cur.add(a[j]);
                dfs(a, j + 1, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
