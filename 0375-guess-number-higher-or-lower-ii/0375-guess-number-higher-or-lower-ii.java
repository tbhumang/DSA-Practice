class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int length = 2; length <= n; length++){
            for(int left = 1; left + length - 1 <= n; left++){
                int right = left + length - 1;
                dp[left][right] = Integer.MAX_VALUE;
                for(int guess = left; guess <= right; guess++){
                    int leftCost = 0;
                    int rightCost = 0;
                    if(guess > left){
                        leftCost = dp[left][guess - 1];
                    }
                    if(guess < right){
                        rightCost = dp[guess + 1][right];
                    }
                    int cost = guess + Math.max(leftCost, rightCost);
                    dp[left][right] = Math.min(dp[left][right], cost);
                }
            }
        }
        return dp[1][n];
    }
}