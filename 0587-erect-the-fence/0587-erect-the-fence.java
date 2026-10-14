class Solution {
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int n = trees.length;
        if (n <= 3) return trees;

        boolean[] used = new boolean[n];
        int[] stack = new int[2 * n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            while (k >= 2 && cross(trees[stack[k - 2]], trees[stack[k - 1]], trees[i]) < 0)
                k--;
            stack[k++] = i;
        }

        int lower = k;
        for (int i = n - 2; i >= 0; i--) {
            while (k > lower && cross(trees[stack[k - 2]], trees[stack[k - 1]], trees[i]) < 0)
                k--;
            stack[k++] = i;
        }

        for (int i = 0; i < k - 1; i++) {
            if (!used[stack[i]]) {
                res.add(trees[stack[i]]);
                used[stack[i]] = true;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    private int cross(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }
}