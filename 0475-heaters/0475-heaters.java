class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for(int h : houses){
            int i = Arrays.binarySearch(heaters, h);
            if(i >= 0) continue;
            i = -i - 1;
            int right = i < heaters.length? heaters[i] - h: Integer.MAX_VALUE;
            int left = i > 0 ? h - heaters[i - 1] : Integer.MAX_VALUE;

            ans = Math.max(ans, Math.min(left, right));
        }
        return ans;
    }
}