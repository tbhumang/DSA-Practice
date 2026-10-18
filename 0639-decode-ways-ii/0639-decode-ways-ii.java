class Solution {
    public int numDecodings(String s) {
        long mod = 1000000007, a = 1, b = ways1(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            long c = (b * ways1(s.charAt(i)) + a * ways2(s.charAt(i - 1), s.charAt(i))) % mod;
            a = b;
            b = c;
        }

        return (int) b;
    }

    private int ways1(char c) {
        if (c == '*') return 9;
        return c == '0' ? 0 : 1;
    }

    private int ways2(char a, char b) {
        if (a == '*' && b == '*') return 15;
        if (a == '*') return b <= '6' ? 2 : 1;
        if (b == '*') return a == '1' ? 9 : a == '2' ? 6 : 0;
        int num = (a - '0') * 10 + b - '0';
        return num >= 10 && num <= 26 ? 1 : 0;
    }
}