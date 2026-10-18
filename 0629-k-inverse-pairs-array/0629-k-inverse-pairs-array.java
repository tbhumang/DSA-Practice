class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] next = new int[k + 1];
            next[0] = 1;
            for (int j = 1; j <= k; j++)
                next[j] = (int) (((long) dp[j] + next[j - 1] - (j >= i ? dp[j - i] : 0) + mod) % mod);
            dp = next;
        }

        return dp[k];
    }
}