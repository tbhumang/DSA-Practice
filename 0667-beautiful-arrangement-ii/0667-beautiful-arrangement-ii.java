class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int l = 1, r = n, i = 0;

        while (l <= r) {
            if (k > 1) {
                ans[i++] = k-- % 2 == 1 ? l++ : r--;
            } else {
                ans[i++] = l++;
            }
        }
        return ans;
    }
}