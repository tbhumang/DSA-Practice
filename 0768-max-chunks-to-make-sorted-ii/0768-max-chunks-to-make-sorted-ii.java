class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);
        int ans = 0, sum = 0, sum2 = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum2 += sorted[i];
            if (sum == sum2) ans++;
        }
        return ans;
    }

}