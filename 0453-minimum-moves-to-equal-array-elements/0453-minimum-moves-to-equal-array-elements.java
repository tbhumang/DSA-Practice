class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long ans = 0;
        for(int num : nums){
            min = Math.min(min, num);
        }
        for(int num : nums){
            ans += num - (long) min;
        }
        return (int) ans;
    }
}