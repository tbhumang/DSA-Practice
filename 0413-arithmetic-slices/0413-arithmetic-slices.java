class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        int ans = 0;
        int count = 0;
        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                count++;
                ans += count;
            } else{
                count = 0;
            }
        }
        return ans;
    }
}