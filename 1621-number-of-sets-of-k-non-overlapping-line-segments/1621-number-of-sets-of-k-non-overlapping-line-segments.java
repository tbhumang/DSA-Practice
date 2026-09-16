class Solution {
    static final long MOD = 1000000007L;

    public int numberOfSets(int n, int k) {
        int m = n + k - 1;
        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];

        fact[0] = 1;
        for (int i = 1; i <= m; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[m] = power(fact[m], MOD - 2);
        for (int i = m; i >= 1; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        return (int)(fact[m] * invFact[2 * k] % MOD * invFact[m - 2 * k] % MOD);
    }

    private long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}