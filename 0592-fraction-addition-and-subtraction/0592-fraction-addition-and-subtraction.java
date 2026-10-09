class Solution {
    public String fractionAddition(String expression) {
        int num = 0, den = 1, i = 0;
        while (i < expression.length()) {
            int sign = 1;
            if (expression.charAt(i) == '-') sign = -1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') i++;
            int n = 0, d = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i)))
                n = n * 10 + expression.charAt(i++) - '0';
            i++;
            while (i < expression.length() && Character.isDigit(expression.charAt(i)))
                d = d * 10 + expression.charAt(i++) - '0';
            num = num * d + sign * n * den;
            den *= d;
            int g = gcd(Math.abs(num), den);
            num /= g;
            den /= g;
        }
        return num + "/" + den;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}