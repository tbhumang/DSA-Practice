import java.util.*;

class Solution {
    static final double TARGET = 24.0;
    static final double EPS = 1e-4;

    public boolean judgePoint24(int[] cards) {
        List<Double> a = new ArrayList<>();
        for (int x : cards) a.add((double)x);
        return dfs(a);
    }

    private boolean dfs(List<Double> a) {
        int n = a.size();
        if (n == 1) return Math.abs(a.get(0) - TARGET) < EPS;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double x = a.get(i), y = a.get(j);
                List<Double> rest = new ArrayList<>(n - 1);
                for (int k = 0; k < n; k++) if (k != i && k != j) rest.add(a.get(k));
                double[] cand = new double[]{x + y, x * y, x - y, y - x};
                for (double v : cand) {
                    rest.add(v);
                    if (dfs(rest)) return true;
                    rest.remove(rest.size() - 1);
                }
                if (Math.abs(y) > EPS) { rest.add(x / y); if (dfs(rest)) return true; rest.remove(rest.size() - 1); }
                if (Math.abs(x) > EPS) { rest.add(y / x); if (dfs(rest)) return true; rest.remove(rest.size() - 1); }
            }
        }
        return false;
    }
}