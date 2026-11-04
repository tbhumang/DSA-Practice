import java.util.*;

class Solution {
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 1, CLOSE = -1;
        List<int[]> events = new ArrayList<>();
        Set<Integer> Xvals = new HashSet<>();
        for (int[] rec : rectangles) {
            if (rec[0] < rec[2] && rec[1] < rec[3]) {
                events.add(new int[]{rec[1], OPEN, rec[0], rec[2]});  // Opening event at y1
                events.add(new int[]{rec[3], CLOSE, rec[0], rec[2]}); // Closing event at y2
                Xvals.add(rec[0]);
                Xvals.add(rec[2]);
            }
        }
        events.sort(Comparator.comparingInt(a -> a[0]));
        Integer[] X = Xvals.toArray(new Integer[0]);
        Arrays.sort(X);
        Map<Integer, Integer> Xi = new HashMap<>();
        for (int i = 0; i < X.length; ++i) {
            Xi.put(X[i], i);
        }
        Node active = new Node(0, X.length - 1, X);
        long ans = 0;
        long cur_x_sum = 0;
        int cur_y = events.get(0)[0];
        for (int[] event : events) {
            int y = event[0], type = event[1], x1 = event[2], x2 = event[3];
            ans += cur_x_sum * (y - cur_y);
            cur_x_sum = active.update(Xi.get(x1), Xi.get(x2), type);
            cur_y = y;
        }

        return (int) (ans % 1_000_000_007);
    }
}
class Node {
    int start, end;
    Integer[] X;
    Node left, right;
    int count;
    long total;
    public Node(int start, int end, Integer[] X) {
        this.start = start;
        this.end = end;
        this.X = X;
        left = null;
        right = null;
        count = 0;
        total = 0;
    }
    public int getRangeMid() {
        return start + (end - start) / 2;
    }
    public Node getLeft() {
        if (left == null) left = new Node(start, getRangeMid(), X);
        return left;
    }
    public Node getRight() {
        if (right == null) right = new Node(getRangeMid(), end, X);
        return right;
    }
    public long update(int i, int j, int val) {
        if (i >= j) return 0; // Invalid case
        if (start == i && end == j) {
            count += val;
        } else {
            getLeft().update(i, Math.min(getRangeMid(), j), val);
            getRight().update(Math.max(getRangeMid(), i), j, val);
        }
        if (count > 0) total = X[end] - X[start];
        else total = getLeft().total + getRight().total;

        return total;
    }
}