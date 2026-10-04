import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num - k)) {
                pairs.add(num - k);
            }
            if (set.contains(num + k)) {
                pairs.add(num);
            }
            set.add(num);
        }
        return pairs.size();
    }
}
