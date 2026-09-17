class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for(int i = 0; i< timeSeries.length; i++)
        ans += i == timeSeries.length - 1 ? duration:
        Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        return ans;
    }
}