class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();

        int[][] dp = new int[m + 1][n];

        for (int i = 0; i <= m; i++) {
            java.util.Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int pos = 0; pos < n; pos++) {
                if (dp[i][pos] == Integer.MAX_VALUE) {
                    continue;
                }

                for (int next = 0; next < n; next++) {
                    if (ring.charAt(next) == key.charAt(i)) {
                        int diff = Math.abs(pos - next);
                        int rotate = Math.min(diff, n - diff);

                        dp[i + 1][next] = Math.min(
                            dp[i + 1][next],
                            dp[i][pos] + rotate + 1
                        );
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;

        for (int pos = 0; pos < n; pos++) {
            ans = Math.min(ans, dp[m][pos]);
        }
        return ans;
    }
}
