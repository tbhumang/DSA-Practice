class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        int len = m + n - 1;
        if ((len & 1) == 1) {
            return false;
        }
        boolean[][][] dp = new boolean[m][n][len + 1];
        dp[0][0][1] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                for (int balance = 0; balance <= len; balance++) {
                    if (i > 0 && dp[i - 1][j][balance]) {
                        int next = balance + (grid[i][j] == '(' ? 1 : -1);
                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                    if (j > 0 && dp[i][j - 1][balance]) {
                        int next = balance + (grid[i][j] == '(' ? 1 : -1);
                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}
