import java.util.*;
class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {
            int hours = Integer.parseInt(time.substring(0, 2));
            int minutes = Integer.parseInt(time.substring(3, 5));
            times.add(hours * 60 + minutes);
        }
        Collections.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < times.size(); i++) {
            min = Math.min(min, times.get(i) - times.get(i - 1));
        }
        min = Math.min(min, 1440 - times.get(times.size() - 1) + times.get(0));
        return min;
    }
}
