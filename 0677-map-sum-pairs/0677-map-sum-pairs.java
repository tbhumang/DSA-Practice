import java.util.HashMap;
import java.util.Map;

class MapSum {
    private Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int total = 0;

        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                total += map.get(key);
            }
        }

        return total;
    }
}