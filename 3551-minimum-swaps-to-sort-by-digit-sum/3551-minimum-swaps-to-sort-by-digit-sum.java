
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            int x = nums[i], sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            a[i] = new int[]{nums[i], sum};
        }

        Arrays.sort(a, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);

        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) pos.put(nums[i], i);

        boolean[] seen = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (seen[i]) continue;
            int j = i, len = 0;

            while (!seen[j]) {
                seen[j] = true;
                j = pos.get(a[j][0]);
                len++;
            }

            if (len > 1) swaps += len - 1;
        }

        return swaps;
    }
}
