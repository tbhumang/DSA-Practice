import java.util.*;

class Solution {
    TreeMap<Integer,Integer> left = new TreeMap<>();
    TreeMap<Integer,Integer> right = new TreeMap<>();
    int lsize = 0, rsize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            
            if (i >= k) remove(nums[i - k]);
            
            if (i >= k - 1) ans[i - k + 1] = median();
        }
        return ans;
    }

    void add(int x) {
        if (left.isEmpty() || x <= left.lastKey()) {
            left.put(x, left.getOrDefault(x, 0) + 1);
            lsize++;
        } else {
            right.put(x, right.getOrDefault(x, 0) + 1);
            rsize++;
        }
        balance();
    }

    void remove(int x) {
        if (left.containsKey(x)) {
            left.put(x, left.get(x) - 1);
            if (left.get(x) == 0) left.remove(x);
            lsize--;
        } else {
            right.put(x, right.get(x) - 1);
            if (right.get(x) == 0) right.remove(x);
            rsize--;
        }
        balance();
    }

    void balance() {
        while (lsize > rsize + 1) {
            int x = left.lastKey();
            addMap(right, x);
            removeMap(left, x);
            lsize--;
            rsize++;
        }

        while (lsize < rsize) {
            int x = right.firstKey();
            addMap(left, x);
            removeMap(right, x);
            rsize--;
            lsize++;
        }
    }

    void addMap(TreeMap<Integer,Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    void removeMap(TreeMap<Integer,Integer> map, int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0) map.remove(x);
    }

    double median() {
        if (lsize > rsize) return left.lastKey();
        return ((double) left.lastKey() + right.firstKey()) / 2.0;
    }
}
