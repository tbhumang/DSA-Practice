class Solution {
    long mod = 1000000007;
    long[][] c = new long[1001][1001];

    public int numOfWays(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++)
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
        }
        return (int) ((solve(Arrays.stream(nums).boxed().toList()) - 1 + mod) % mod);
    }

    long solve(List<Integer> a) {
        if (a.size() < 3) return 1;
        int root = a.get(0);
        List<Integer> l = new ArrayList<>(), r = new ArrayList<>();
        for (int i = 1; i < a.size(); i++)
            if (a.get(i) < root) l.add(a.get(i));
            else r.add(a.get(i));
        return c[l.size() + r.size()][l.size()] * solve(l) % mod * solve(r) % mod;
    }
}