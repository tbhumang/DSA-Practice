import java.util.*;
class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> {
            int x = intervals.get(a).get(0), y = intervals.get(b).get(0);
            if (x != y) return Integer.compare(x, y);
            return Integer.compare(a, b);
        });

        long[] dp = new long[(n + 1) * 5];
        ArrayList<Integer>[][] pick = new ArrayList[n + 1][5];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= 4; j++)
                pick[i][j] = new ArrayList<>();
        int[] starts = new int[n];
        for (int i = 0; i < n; i++)
            starts[i] = intervals.get(order[i]).get(0);
        for (int i = n - 1; i >= 0; i--) {
            int idx = order[i];
            int l = intervals.get(idx).get(0);
            int r = intervals.get(idx).get(1);
            int w = intervals.get(idx).get(2);
            int next = upperBound(starts, r);
            for (int k = 1; k <= 4; k++) {
                long skipScore = dp[(i + 1) * 5 + k];
                long takeScore = w + dp[next * 5 + k - 1];
                if (takeScore > skipScore) {
                    dp[i * 5 + k] = takeScore;
                    pick[i][k] = new ArrayList<>();
                    pick[i][k].add(idx);
                    pick[i][k].addAll(pick[next][k - 1]);
                } else if (takeScore < skipScore) {
                    dp[i * 5 + k] = skipScore;
                    pick[i][k] = new ArrayList<>(pick[i + 1][k]);
                } else {
                    dp[i * 5 + k] = skipScore;

                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(idx);
                    a.addAll(pick[next][k - 1]);

                    ArrayList<Integer> b = pick[i + 1][k];

                    a.sort(Integer::compareTo);
                    b.sort(Integer::compareTo);

                    pick[i][k] = smaller(a, b);
                }
            }
        }

        ArrayList<Integer> ans = pick[0][4];
        Collections.sort(ans);

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > target)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    private ArrayList<Integer> smaller(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i)))
                return a.get(i) < b.get(i) ? a : b;
        }
        return a.size() <= b.size() ? a : b;
    }
}
