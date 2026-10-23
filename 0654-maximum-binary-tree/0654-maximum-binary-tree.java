class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int max = l;
        for (int i = l + 1; i <= r; i++)
            if (nums[i] > nums[max]) max = i;
        TreeNode root = new TreeNode(nums[max]);
        root.left = build(nums, l, max - 1);
        root.right = build(nums, max + 1, r);
        return root;
    }
}