import java.util.*;
class Solution {
    HashMap<Integer, List<Integer>> map;
    Random random;
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
