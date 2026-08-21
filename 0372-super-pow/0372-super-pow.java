class Solution {
    public int superPow(int a, int[] b) {
        int MOD = 1337;
        a%= MOD;
        int result = 1;
        for(int digit : b){
            result = (pow(result, 10) * pow(a, digit)) % MOD;
        }
        return result;
    }
    private int pow(int base, int exp){
        int MOD = 1337;
        int result = 1;

        while(exp > 0){
            if((exp & 1) == 1){
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}