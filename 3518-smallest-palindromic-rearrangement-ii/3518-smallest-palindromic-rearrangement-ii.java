class Solution {
    private static final long LIMIT = 1_000_000L;
    private long combCap(int n, int r){
        if(r < 0 || r > n) return 0;
        r = Math.min(r, n - r);
        long res = 1;
        for(int i = 1; i<= r; i++){
            res = res * (n - r + i)/ i;
            if(res >= LIMIT) return LIMIT;
        }
        return res;
    }
    private long countWays(int[] cnt){
        int total = 0;
        for(int x : cnt) total += x;
        long ans = 1;
        int rem = total;
        for(int x : cnt){
            if(x == 0) continue;
            ans *= combCap(rem, x);
            if(ans >= LIMIT) return LIMIT;
            rem -= x;
        }
        return ans;
    }
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();
        for(int i =0; i< 26; i++){
            half[i] = freq[i] / 2;
            if((freq[i] & 1) == 1){
                mid.append((char) ('a' + i));
            }
        }
        if(countWays(half) < k){
            return "";
        }
        int halfLen = 0;
        for(int x : half) halfLen += x;
        StringBuilder left = new StringBuilder();
        for(int pos = 0; pos < halfLen; pos++){
            for(int c = 0; c < 26; c++){
                if(half[c] == 0) continue;
                half[c]--;
                long ways = countWays(half);
                if(ways >= k){
                    left.append((char) ('a' + c));
                    break;
                }
                k -= ways;
                half[c]++;
            }
        }
        StringBuilder right = new StringBuilder(left).reverse();
        return left.toString() + mid.toString() + right.toString();
    }
}