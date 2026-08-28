class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, targetSum, map);        
    }
    private int dfs(TreeNode root, long sum, int targetSum,
    HashMap<Long, Integer> map){
        if(root == null){
            return 0;
        }
        sum += root.val;
        int count = 0;
    if(map.containsKey(sum - targetSum)){
        count += map.get(sum - targetSum);
    }
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    count += dfs(root.left, sum, targetSum, map);
    count += dfs(root.right, sum, targetSum, map);
    map.put(sum, map.get(sum) - 1);
    if(map.get(sum) == 0){
        map.remove(sum);
    }
    return count;
}
}