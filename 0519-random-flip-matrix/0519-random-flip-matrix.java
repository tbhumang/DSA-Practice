import java.util.*;
class Solution {
    int m, n;
    int total;
    HashMap<Integer, Integer> map;
    Random random;
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.random = new Random();
    }
    public int[] flip() {
        int r = random.nextInt(total);

        int index = map.getOrDefault(r, r);
        total--;
        map.put(r, map.getOrDefault(total, total));
        return new int[]{index / n, index % n};
    }
    public void reset() {
        total = m * n;
        map.clear();
    }
}
