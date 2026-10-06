class Solution {
    public String nearestPalindromic(String n) {
        long x = Long.parseLong(n);
        int len = n.length();
        long a = (long)Math.pow(10, len - 1) - 1;
        long b = (long)Math.pow(10, len) + 1;
        long p = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long v = p - 1; v <= p + 1; v++) {
            String s = String.valueOf(v);
            String t = s + new StringBuilder(
                len % 2 == 0 ? s : s.substring(0, s.length() - 1)
            ).reverse();
            long y = Long.parseLong(t);
            if (y != x) {
                if (Math.abs(y - x) < Math.abs(a - x))
                    a = y;
                if (Math.abs(y - x) < Math.abs(b - x))
                    b = y;
            }
        }
        if (Math.abs(a - x) <= Math.abs(b - x))
            return String.valueOf(a);
        return String.valueOf(b);
    }
}
