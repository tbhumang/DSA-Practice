class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        Boolean[] memo = new Boolean[1 << maxChoosableInteger];
        return solve(0, desiredTotal, maxChoosableInteger, memo);
    }
    private boolean solve(int mask, int remaining, int max, Boolean[] memo) {
        if (memo[mask] != null) {
            return memo[mask];
        }
        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                if (i >= remaining || !solve(mask | bit, remaining - i, max, memo)) {
                    return memo[mask] = true;
                }
            }
        }
        return memo[mask] = false;
    }
}
