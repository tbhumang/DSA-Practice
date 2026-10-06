class Solution {
    int ans = 0;
    public int findTilt(TreeNode root) {
             sum(root);
      return ans;
    }
    int sum(TreeNode root) {
        if (root == null)
          return 0;
        int l = sum(root.left);
        int r = sum(root.right);
        ans += Math.abs(l - r);
        return l + r + root.val;
    }
}
