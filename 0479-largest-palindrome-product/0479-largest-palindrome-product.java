class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int)Math.pow(10, n) - 1;
        for (int left = max; left >= 0; left--) {
            long p = left;
            long x = left;
            while (x > 0) {
                p = p * 10 + x % 10;
                x /= 10;
            }
            for (long i = max; i * i >= p; i--) {
                if (p % i == 0)
                    return (int)(p % 1337);
            }
        }
        return 0;
    }
}
