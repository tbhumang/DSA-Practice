class Solution {
    public int monotoneIncreasingDigits(int n) {
        var digits = new int[10];
        for (var i = 9; i >= 0; i --) {
            digits[i] = n % 10;
            n /= 10;
        }
        for (var i = 0; i < 9; i ++) {
            if (digits[i] > digits[i + 1]) {
                digits[i] --;
                for (var j = i + 1; j < 10; j ++)
                    digits[j] = 9;
                i = -1;
            }
        }
        var x = 0;
        for (var i = 0; i < 10; i ++)
            x = x * 10 + digits[i];
        return x;
    }
}