class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, ans = Integer.MAX_VALUE, best = Integer.MAX_VALUE;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sum = 0, l = 0;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) sum -= arr[l++];
            if (sum == target) {
                int len = r - l + 1;
                if (l > 0 && dp[l - 1] != Integer.MAX_VALUE)
                    ans = Math.min(ans, len + dp[l - 1]);
                best = Math.min(best, len);
            }
            dp[r] = best;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
