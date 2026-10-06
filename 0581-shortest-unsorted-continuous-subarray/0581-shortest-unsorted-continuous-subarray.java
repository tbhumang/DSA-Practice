class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int l = -1, r = -1;
        int max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max)
                r = i;
        }
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                l = i;
        }
        return l == -1 ? 0 : r - l + 1;
    }
}
