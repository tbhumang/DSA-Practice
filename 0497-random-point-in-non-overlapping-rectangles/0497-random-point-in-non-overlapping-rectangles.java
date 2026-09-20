import java.util.*;

class Solution {
    int[][] rects;
    long[] sum;
    Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        sum = new long[rects.length];
        
        for (int i = 0; i < rects.length; i++) {
            long w = rects[i][2] - rects[i][0] + 1L;
            long h = rects[i][3] - rects[i][1] + 1L;
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + w * h;
        }
    }

    public int[] pick() {
        long target = 1 + (Math.abs(random.nextLong()) % sum[sum.length - 1]);
        int l = 0, r = sum.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (sum[m] >= target)
                r = m;
            else
                l = m + 1;
        }

        int[] rec = rects[l];
        long before = l == 0 ? 0 : sum[l - 1];
        long pos = target - before - 1;

        long width = rec[2] - rec[0] + 1L;
        int x = (int)(rec[0] + pos % width);
        int y = (int)(rec[1] + pos / width);

        return new int[]{x, y};
    }
}