class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while(k > 0){
            long steps = count(cur, n);
            if(steps <= k){
                cur++;
                k -= steps;
            } else{
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
    private long count(long cur, int n){
        long steps = 0;
        long next = cur + 1;
        while(cur <= n){
            steps += Math.min((long) n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return steps;
    }
}