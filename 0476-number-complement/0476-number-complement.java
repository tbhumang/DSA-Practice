class Solution {
    public int findComplement(int num) {
        int mask = Integer.highestOneBit(num) * 2 - 1;
        return num ^ mask;
    }
}