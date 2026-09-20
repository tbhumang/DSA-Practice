class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int r = 0, c = 0, k = 0;

        while (k < m * n) {
            while (r >= 0 && c < n) {
                ans[k++] = mat[r--][c++];
            }

            if (c == n) {
                c = n - 1;
                r += 2;
            } else {
                r++;
            }

            while (r < m && c >= 0) {
                ans[k++] = mat[r++][c--];
            }

            if (r == m) {
                r = m - 1;
                c += 2;
            } else {
                c++;
            }
        }

        return ans;
    }
}
